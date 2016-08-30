package ru.otr.lbss.service.ftp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.GeneralSecurityException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.ftpserver.DataConnectionConfigurationFactory;
import org.apache.ftpserver.FtpServerConfigurationException;
import org.apache.ftpserver.impl.DefaultFtpHandler;
import org.apache.ftpserver.impl.FtpHandler;
import org.apache.ftpserver.impl.FtpIoSession;
import org.apache.ftpserver.impl.FtpServerContext;
import org.apache.ftpserver.ipfilter.IpFilter;
import org.apache.ftpserver.ipfilter.MinaIpFilter;
import org.apache.ftpserver.listener.nio.AbstractListener;
import org.apache.ftpserver.listener.nio.FtpHandlerAdapter;
import org.apache.ftpserver.listener.nio.FtpLoggingFilter;
import org.apache.ftpserver.listener.nio.FtpServerProtocolCodecFactory;
import org.apache.ftpserver.ssl.ClientAuth;
import org.apache.ftpserver.ssl.SslConfiguration;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.filter.logging.MdcInjectionFilter;
import org.apache.mina.filter.ssl.SslFilter;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.SocketSessionConfig;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FTPListener extends AbstractListener {
    private static Logger log = LoggerFactory.getLogger(FTPListener.class);

    private SocketAcceptor acceptor;
    private InetSocketAddress address;
    boolean suspended = false;
    private FtpHandler handler = new DefaultFtpHandler();
    private FtpServerContext context;
    private boolean loggerFilterEnable;

    public FTPListener(String serverAddress, int port, boolean loggerFilterEnable) {
        super(serverAddress, port, false, null, new DataConnectionConfigurationFactory().createDataConnectionConfiguration(), 300, null);
        this.loggerFilterEnable = loggerFilterEnable;
    }

    @Override
    public void start(FtpServerContext context) {
        if (!isStopped()) {
            throw new IllegalStateException("Listener already started");
        }
        try {
            this.context = context;

            acceptor = new NioSocketAcceptor(Runtime.getRuntime().availableProcessors());

            if (getServerAddress() != null) {
                address = new InetSocketAddress(getServerAddress(), getPort());
            } else {
                address = new InetSocketAddress(getPort());
            }

            acceptor.setReuseAddress(true);
            acceptor.getSessionConfig().setReadBufferSize(2048);
            acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, getIdleTimeout());
            // Decrease the default receiver buffer size
            ((SocketSessionConfig) acceptor.getSessionConfig()).setReceiveBufferSize(512);

            MdcInjectionFilter mdcFilter = new MdcInjectionFilter();

            acceptor.getFilterChain().addLast("mdcFilter", mdcFilter);

            IpFilter ipFilter = getIpFilter();
            if (ipFilter != null) {
                // add and IP filter to the filter chain.
                acceptor.getFilterChain().addLast("ipFilter", new MinaIpFilter(ipFilter));
            }

            acceptor.getFilterChain().addLast("threadPool", new ExecutorFilter(context.getThreadPoolExecutor()));
            acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new FtpServerProtocolCodecFactory()));
            acceptor.getFilterChain().addLast("mdcFilter2", mdcFilter);
            if (loggerFilterEnable) {
                acceptor.getFilterChain().addLast("logger", new FtpLoggingFilter());
            }
            if (isImplicitSsl()) {
                SslConfiguration ssl = getSslConfiguration();
                SslFilter sslFilter;
                try {
                    sslFilter = new SslFilter(ssl.getSSLContext());
                } catch (GeneralSecurityException e) {
                    throw new FtpServerConfigurationException("SSL could not be initialized, check configuration");
                }

                if (ssl.getClientAuth() == ClientAuth.NEED) {
                    sslFilter.setNeedClientAuth(true);
                } else if (ssl.getClientAuth() == ClientAuth.WANT) {
                    sslFilter.setWantClientAuth(true);
                }

                if (ssl.getEnabledCipherSuites() != null) {
                    sslFilter.setEnabledCipherSuites(ssl.getEnabledCipherSuites());
                }

                acceptor.getFilterChain().addFirst("sslFilter", sslFilter);
            }

            handler.init(context, this);
            acceptor.setHandler(new FtpHandlerAdapter(context, handler));

            try {
                acceptor.bind(address);
            } catch (IOException e) {
                throw new FtpServerConfigurationException("Failed to bind to address " + address + ", check configuration", e);
            }
            updatePort();
        } catch (RuntimeException e) {
            // clean up if we fail to start
            stop();

            throw e;
        }
    }

    private void updatePort() {
        // update the port to the real port bound by the listener
        setPort(acceptor.getLocalAddress().getPort());
    }

    @Override
    public synchronized void stop() {
        // close server socket
        if (acceptor != null) {
            acceptor.unbind();
            acceptor.dispose();
            acceptor = null;
        }
        context = null;
    }

    @Override
    public boolean isStopped() {
        return acceptor == null;
    }

    @Override
    public boolean isSuspended() {
        return suspended;

    }

    @Override
    public synchronized void resume() {
        if (acceptor != null && suspended) {
            try {
                log.debug("Resuming listener");
                acceptor.bind(address);
                log.debug("Listener resumed");

                updatePort();

                suspended = false;
            } catch (IOException e) {
                log.error("Failed to resume listener", e);
            }
        }
    }

    @Override
    public synchronized void suspend() {
        if (acceptor != null && !suspended) {
            log.debug("Suspending listener");
            acceptor.unbind();

            suspended = true;
            log.debug("Listener suspended");
        }
    }

    @Override
    public synchronized Set<FtpIoSession> getActiveSessions() {
        Map<Long, IoSession> sessions = acceptor.getManagedSessions();

        Set<FtpIoSession> ftpSessions = new HashSet<FtpIoSession>();
        for (IoSession session : sessions.values()) {
            ftpSessions.add(new FtpIoSession(session, context));
        }
        return ftpSessions;
    }

}
