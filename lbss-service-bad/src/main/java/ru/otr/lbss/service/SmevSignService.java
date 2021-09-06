package ru.otr.lbss.service;

import java.io.UnsupportedEncodingException;

import javax.annotation.PostConstruct;
import javax.xml.ws.BindingProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;

import com.otr.sufd.smev30supportservice.FaultMessage;
import com.otr.sufd.smev30supportservice.SignXmlParams;
import com.otr.sufd.smev30supportservice.Smev30SupportService;
import com.otr.sufd.smev30supportservice.Smev30SupportServicePortType;

import cxc.jex.common.application.config.PropertiesService;
import cxc.jex.common.application.message.ApplicationMessageService;
import cxc.jex.common.exception.ExceptionWrapper;
import cxc.jex.common.xml.dsig.SignatureProtector;
import cxc.jex.common.xml.transform.JAXBTransformer;
import ru.otr.lbss.client.api.SmevPrimeServiceLocal;
import ru.otr.lbss.client.model.types.SendRequestResponse;
import ru.otr.lbss.client.model.types.SendResponseResponse;
import ru.otr.lbss.client.model.types.SmevAsyncProcessingMessage;
import ru.otr.lbss.client.model.types.GetRequestResponse.RequestMessage;
import ru.otr.lbss.client.model.types.GetResponseResponse.ResponseMessage;
import ru.otr.lbss.client.model.types.basic.XMLDSigSignatureType;
import ru.otr.lbss.service.config.ServiceProperties;
import ru.otr.lbss.service.config.ModeService;

public class SmevSignService {
	public static enum Mode {
		STUB, ENABLE, DISABLE
	}

	private static Logger log = LoggerFactory.getLogger(SmevSignService.class);

	@Autowired
	private ModeService modeService;
	@Autowired
	private ApplicationMessageService applMsgService;
	@Autowired
	private PropertiesService propertiesService;
	@Autowired
	private JAXBTransformer transformer;

	private SignatureProtector protector;
	private static Smev30SupportService cryptoWebService = new Smev30SupportService();

	private Smev30SupportServicePortType cryptoWebServicePort;

	@PostConstruct
	public void init() {
		log.info("init");
		try {
			protector = new SignatureProtector();

			if (getMode() == Mode.ENABLE) {
				cryptoWebServicePort = cryptoWebService.getSmev30SupportServicePort();
				String cryptoWebServiceURI = propertiesService.getString(ServiceProperties.SignService_cryptoWebServiceURI);
				log.info("CryptoWebService URI : " + cryptoWebServiceURI);
				BindingProvider provider = (BindingProvider) cryptoWebServicePort;
				provider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, cryptoWebServiceURI);
			}
		} catch (ExceptionWrapper e) {
			throw new RuntimeException(e);
		}
	}

	public Mode getMode() {
		if (modeService.getPrimeServiceMode() == SmevPrimeServiceLocal.Mode.LIVE) {
			return modeService.getSignServiceMode();
		} else {
			return Mode.DISABLE;
		}
	}

	public XMLDSigSignatureType makePackedSignature(String signature) throws ExceptionWrapper {
		XMLDSigSignatureType result = new XMLDSigSignatureType();
		result.setAny(transformer.xml2dom(protector.packSignature(signature)).getDocumentElement());
		return result;
	}

	public XMLDSigSignatureType getSTUBPackedSignature() throws ExceptionWrapper {
		return makePackedSignature(transformer.base2xml(applMsgService.getMessage("STUB.SignatureBase64")));
	}

	public void signSMEVSignature(RequestMessage requestMessage) throws ExceptionWrapper {
		switch (getMode()) {
		case STUB:
			requestMessage.setSMEVSignature(getSTUBPackedSignature());
			break;
		case ENABLE:
			try {
				Document dom = transformer.xml2dom(transformer.obj2xml(requestMessage.getRequest()));
				protector.unpackAllSignatures(dom);
				SignXmlParams params = new SignXmlParams();
				params.setXml(transformer.dom2xml(dom).getBytes("UTF-8"));
				params.setReference(requestMessage.getRequest().getId());
				params.setDetached(true);
				String signature = new String(cryptoWebServicePort.signXml(params), "UTF-8");
				requestMessage.setSMEVSignature(makePackedSignature(signature));
			} catch (FaultMessage e) {
				throw new ExceptionWrapper(e);
			} catch (UnsupportedEncodingException e) {
				throw new ExceptionWrapper(e);
			}
			break;
		default:
			break;
		}
	}

	public void signSMEVSignature(ResponseMessage responseMessage) throws ExceptionWrapper {
		switch (getMode()) {
		case STUB:
			responseMessage.setSMEVSignature(getSTUBPackedSignature());
			break;
		case ENABLE:
			try {
				Document dom = transformer.xml2dom(transformer.obj2xml(responseMessage.getResponse()));
				protector.unpackAllSignatures(dom);
				SignXmlParams params = new SignXmlParams();
				params.setXml(transformer.dom2xml(dom).getBytes("UTF-8"));
				params.setReference(responseMessage.getResponse().getId());
				params.setDetached(true);
				String signature = new String(cryptoWebServicePort.signXml(params), "UTF-8");
				responseMessage.setSMEVSignature(makePackedSignature(signature));
			} catch (FaultMessage e) {
				throw new ExceptionWrapper(e);
			} catch (UnsupportedEncodingException e) {
				throw new ExceptionWrapper(e);
			}
			break;
		default:
			break;
		}
	}

	public void signSMEVSignature(SmevAsyncProcessingMessage statusMessage) throws ExceptionWrapper {
		switch (getMode()) {
		case STUB:
			statusMessage.setSMEVSignature(getSTUBPackedSignature());
			break;
		case ENABLE:
			try {
				Document dom = transformer.xml2dom(transformer.obj2xml(statusMessage.getAsyncProcessingStatusData()));
				protector.unpackAllSignatures(dom);
				SignXmlParams params = new SignXmlParams();
				params.setXml(transformer.dom2xml(dom).getBytes("UTF-8"));
				params.setReference(statusMessage.getAsyncProcessingStatusData().getId());
				params.setDetached(true);
				String signature = new String(cryptoWebServicePort.signXml(params), "UTF-8");
				statusMessage.setSMEVSignature(makePackedSignature(signature));
			} catch (FaultMessage e) {
				throw new ExceptionWrapper(e);
			} catch (UnsupportedEncodingException e) {
				throw new ExceptionWrapper(e);
			}
			break;
		default:
			break;
		}
	}

	public void signSMEVSignature(SendRequestResponse response) throws ExceptionWrapper {
		switch (getMode()) {
		case STUB:
			response.setSMEVSignature(getSTUBPackedSignature());
			break;
		case ENABLE:
			try {
				SignXmlParams params = new SignXmlParams();
				params.setXml(transformer.obj2xml(response.getMessageMetadata()).getBytes("UTF-8"));
				params.setReference(response.getMessageMetadata().getId());
				params.setDetached(true);
				String signature = new String(cryptoWebServicePort.signXml(params), "UTF-8");
				response.setSMEVSignature(makePackedSignature(signature));
			} catch (FaultMessage e) {
				throw new ExceptionWrapper(e);
			} catch (UnsupportedEncodingException e) {
				throw new ExceptionWrapper(e);
			} catch (javax.xml.ws.WebServiceException e) {
				throw new ExceptionWrapper(e);
			}
			break;
		default:
			break;
		}
	}

	public void signSMEVSignature(SendResponseResponse response) throws ExceptionWrapper {
		switch (getMode()) {
		case STUB:
			response.setSMEVSignature(getSTUBPackedSignature());
			break;
		case ENABLE:
			try {
				SignXmlParams params = new SignXmlParams();
				params.setXml(transformer.obj2xml(response.getMessageMetadata()).getBytes("UTF-8"));
				params.setReference(response.getMessageMetadata().getId());
				params.setDetached(true);
				String signature = new String(cryptoWebServicePort.signXml(params), "UTF-8");
				response.setSMEVSignature(makePackedSignature(signature));
			} catch (FaultMessage e) {
				throw new ExceptionWrapper(e);
			} catch (UnsupportedEncodingException e) {
				throw new ExceptionWrapper(e);
			}
			break;
		default:
			break;
		}
	}

}
