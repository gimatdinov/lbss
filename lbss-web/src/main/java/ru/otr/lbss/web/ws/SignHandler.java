package ru.otr.lbss.web.ws;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cxc.jex.common.exception.ExceptionWrapper;
import cxc.jex.common.xml.dsig.SignatureProtector;

public class SignHandler implements SOAPHandler<SOAPMessageContext> {
	private static Logger log = LoggerFactory.getLogger(SignHandler.class);

	private SignatureProtector protector;

	public SignHandler() {
		log.debug("init");
		try {
			protector = new SignatureProtector();
		} catch (ExceptionWrapper e) {
			log.error(e.getMessage(), e);
		}
	}

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		if (protector == null) {
			log.error("SignatureProtector is not ready!");
			return false;
		}
		try {
			SOAPMessage msg = context.getMessage();
			Boolean isOutbound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
			if (isOutbound) {
				try {
					protector.unpackAllSignatures(msg.getSOAPBody().getOwnerDocument());
				} catch (Exception e) {
					log.error(e.getMessage(), e);
					return false;
				}
			} else {
				try {
					protector.packAllSignatures(msg.getSOAPBody().getOwnerDocument());
				} catch (ExceptionWrapper e) {
					log.error(e.getMessage(), e);
					return false;
				}
			}
			return true;
		} catch (SOAPException e) {
			return false;
		}
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		return true;
	}

	@Override
	public void close(MessageContext context) {

	}

	@Override
	public Set<QName> getHeaders() {
		return null;
	}

}
