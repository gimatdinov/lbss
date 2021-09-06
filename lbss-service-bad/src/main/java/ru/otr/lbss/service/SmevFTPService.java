package ru.otr.lbss.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.ftpserver.DataConnectionConfigurationFactory;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cxc.jex.common.application.config.PropertiesService;
import cxc.jex.common.exception.ExceptionWrapper;
import cxc.jex.common.failure.FailureWrapper;
import ru.otr.lbss.client.model.types.GetRequestResponse.RequestMessage;
import ru.otr.lbss.client.model.types.GetResponseResponse.ResponseMessage;
import ru.otr.lbss.client.model.types.basic.FSAttachmentsList;
import ru.otr.lbss.client.model.types.basic.FSAuthInfo;
import ru.otr.lbss.client.model.types.basic.RefAttachmentHeaderList;
import ru.otr.lbss.client.model.types.basic.RefAttachmentHeaderType;
import ru.otr.lbss.service.config.ServiceProperties;
import ru.otr.lbss.service.config.ModeService;
import ru.otr.lbss.service.ftp.FTPListener;
import ru.otr.lbss.service.ftp.FTPUserManager;
import ru.otr.lbss.service.model.DocNames;
import ru.otr.lbss.service.model.config.ModelProperties;
import ru.otr.lbss.service.model.types.SmevMember;

public class SmevFTPService {
    public static enum Mode {
        COPY, MOVE
    }

    private static Logger log = LoggerFactory.getLogger(SmevFTPService.class);

    @Autowired
    private ModeService modeService;
    @Autowired
    private PropertiesService propertiesService;

    private FtpServer ftpServer;
    private FTPUserManager ftpUserManager;
    private String ftpAddress;

    @PostConstruct
    private void init() {
        log.info("init");
        String ftpDirectory = propertiesService.getString(ServiceProperties.ftp_directory);
        log.info("FTP Directory : " + ftpDirectory);
        int ftpPort = propertiesService.getInteger(ServiceProperties.ftp_port, 21);
        String ftpPassivePorts = propertiesService.getString(ServiceProperties.ftp_passive_ports, "30000-30100");
        try {
            if (!(new File(ftpDirectory)).exists()) {
                throw new ExceptionWrapper("DirectoryNotExists", ftpDirectory);
            }

            String mongoHost = propertiesService.getString(ModelProperties.mongo_host);
            int mongoPort = propertiesService.getInteger(ModelProperties.mongo_port, 27017);

            String dbName = propertiesService.getString(ServiceProperties.ftp_users_database);
            ftpUserManager = new FTPUserManager(ftpDirectory, mongoHost, mongoPort, dbName, DocNames.FTPUser,
                    propertiesService.getString(ServiceProperties.ftp_admin_password, "admin"));
            FtpServerFactory serverFactory = new FtpServerFactory();
            serverFactory.setUserManager(ftpUserManager);

            DataConnectionConfigurationFactory dcConfigFactory = new DataConnectionConfigurationFactory();
            dcConfigFactory.setActiveEnabled(false);
            dcConfigFactory.setPassivePorts(ftpPassivePorts);
            FTPListener ftpListener = new FTPListener(null, ftpPort, dcConfigFactory.createDataConnectionConfiguration(),
                    propertiesService.getBoolean(ServiceProperties.ftp_log_enable, false));
            serverFactory.addListener("default", ftpListener);

            serverFactory.getListeners();
            ftpServer = serverFactory.createServer();
            ftpServer.start();
            ftpAddress = "ftp://SMEV_SERVER:" + ftpPort;
            log.info("FTP Address : " + ftpAddress);
            log.info("FTP Passive ports : " + ftpPassivePorts);

            String users = propertiesService.getString(ServiceProperties.ftp_users_list);
            if (users != null) {
                createUsers(users);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @PreDestroy
    private void fina() {
        log.info("fina");
        ftpServer.stop();
        ftpUserManager.close();
    }

    public Mode getMode() {
        return modeService.getFtpServiceMode();
    }

    private void createUsers(String users) throws ExceptionWrapper {
        log.info("createUsers : " + users);
        String[] _users = users.split(",");
        for (String item : _users) {
            String[] user = item.trim().split(":");
            String userName = user[0].trim();
            String password = user[1].trim();
            try {
                ftpUserManager.save(userName, password, userName, true, false);
            } catch (FtpException e) {
                throw new ExceptionWrapper(e);
            }
        }
    }

    public User saveUser(SmevMember member) throws ExceptionWrapper {
        try {
            return ftpUserManager.save(member.getMnemonic(), member.getFtpUserPassword(), member.getMnemonic(), true, false);
        } catch (FtpException e) {
            throw new ExceptionWrapper(e);
        }
    }

    public User createUser(FSAuthInfo auth) throws ExceptionWrapper {
        try {
            return ftpUserManager.save(auth.getUserName(), auth.getPassword(), auth.getUserName(), false, true);
        } catch (FtpException e) {
            throw new ExceptionWrapper(e);
        }

    }

    private FSAuthInfo makeFSAuthInfo(RefAttachmentHeaderType attach, String senderMnemonic) throws FailureWrapper {
        File dir = new File(new File(ftpUserManager.getFtpDirectory(), senderMnemonic), attach.getUuid());
        if (dir.exists() && dir.isDirectory() && dir.list().length == 1 && dir.listFiles()[0].isFile()) {
            FSAuthInfo result = new FSAuthInfo();
            result.setUuid(attach.getUuid());
            result.setFileName(dir.list()[0]);
            StringBuilder userName = new StringBuilder("user_");
            userName.append(attach.getUuid().substring(0, 4).toUpperCase());
            userName.append(UUID.randomUUID().toString().substring(0, 4).toUpperCase());
            userName.append(System.currentTimeMillis() % 10000);
            result.setUserName(userName.toString());
            result.setPassword(UUID.randomUUID().toString().substring(0, 8));
            return result;
        } else {
            throw new FailureWrapper(new ExceptionWrapper("FileNotFound", ftpAddress + "/" + attach.getUuid() + "/?"));
        }
    }

    public void archive(FSAttachmentsList attachList) throws ExceptionWrapper {
        try {
            for (FSAuthInfo item : attachList.getFSAttachment()) {
                User ftpUser = ftpUserManager.getUserByName(item.getUserName());
                File itemDir = new File(ftpUser.getHomeDirectory(), item.getUuid());
                itemDir.listFiles()[0].delete();
                itemDir.delete();
                ftpUserManager.delete(ftpUser.getName());
            }
        } catch (FtpException e) {
            throw new ExceptionWrapper(e);
        }
    }

    private FSAttachmentsList makeFSAttachmentsList(RefAttachmentHeaderList headerList, String senderMnemonic) throws FailureWrapper {
        try {
            FSAttachmentsList result = new FSAttachmentsList();
            User sender = ftpUserManager.getUserByName(senderMnemonic);
            List<FSAuthInfo> authList = new ArrayList<>();
            for (RefAttachmentHeaderType item : headerList.getRefAttachmentHeader()) {
                authList.add(makeFSAuthInfo(item, senderMnemonic));
            }
            for (FSAuthInfo item : authList) {
                User ftpUser = createUser(item);
                File attachSource = new File(sender.getHomeDirectory(), item.getUuid());
                File attachTarget = new File(ftpUser.getHomeDirectory(), item.getUuid());
                if (getMode() == Mode.COPY) {
                    attachTarget.mkdir();
                    Files.copy(attachSource.listFiles()[0].toPath(), new File(attachTarget, attachSource.listFiles()[0].getName()).toPath());
                } else {
                    Files.move(attachSource.toPath(), attachTarget.toPath());
                }
                log.info("sendAttachment : " + item.getUserName() + "/" + item.getUuid() + "/" + item.getFileName());
                result.getFSAttachment().add(item);
            }
            return result;
        } catch (FtpException e) {
            throw new FailureWrapper(e);
        } catch (IOException e) {
            throw new FailureWrapper(e);
        } catch (ExceptionWrapper e) {
            throw new FailureWrapper(e);
        }
    }

    public void complete(RequestMessage requestMessage) throws FailureWrapper {
        // TODO проверить все списки вложений

        RefAttachmentHeaderList headerList = requestMessage.getRequest().getSenderProvidedRequestData().getRefAttachmentHeaderList();
        if (headerList != null) {
            String senderMnemonic = requestMessage.getRequest().getMessageMetadata().getSender().getMnemonic();
            requestMessage.getRequest().setFSAttachmentsList(makeFSAttachmentsList(headerList, senderMnemonic));
        }

    }

    public void complete(ResponseMessage responseMessage) throws FailureWrapper {
        // TODO проверить все списки вложений

        RefAttachmentHeaderList headerList = responseMessage.getResponse().getSenderProvidedResponseData().getRefAttachmentHeaderList();
        if (headerList != null) {
            String senderMnemonic = responseMessage.getResponse().getMessageMetadata().getSender().getMnemonic();
            responseMessage.getResponse().setFSAttachmentsList(makeFSAttachmentsList(headerList, senderMnemonic));
        }
    }
}
