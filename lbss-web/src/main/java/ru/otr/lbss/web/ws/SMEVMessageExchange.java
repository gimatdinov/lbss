package ru.otr.lbss.web.ws;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.apache.cxf.annotations.SchemaValidation;
import org.apache.cxf.annotations.SchemaValidation.SchemaValidationType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cxc.jex.common.failure.FailureWrapper;
import ru.otr.lbss.client.api.SmevPrimeServiceLocal;
import ru.otr.lbss.client.model.Namespaces;
import ru.otr.lbss.client.model.exceptions.*;
import ru.otr.lbss.client.model.types.*;
import ru.otr.lbss.client.model.types.basic.Void;

@SchemaValidation(type = SchemaValidationType.REQUEST)
@WebService(name = "SMEVMessageExchangeService", targetNamespace = Namespaces.SERVICE)
@HandlerChain(file = "/handler-chain.xml")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({ ru.otr.lbss.client.model.types.ObjectFactory.class, ru.otr.lbss.client.model.types.fault.ObjectFactory.class,
        ru.otr.lbss.client.model.types.basic.ObjectFactory.class })
public class SMEVMessageExchange {
	private static Logger log = LoggerFactory.getLogger(SMEVMessageExchange.class);

	@Autowired
	private SmevPrimeServiceLocal service;

	public SMEVMessageExchange() {
		log.info("init");
	}

	@WebMethod(operationName = "SendRequest", action = "urn:SendRequest")
	@WebResult(name = "SendRequestResponse", targetNamespace = Namespaces.TYPES, partName = "parameters")
	public SendRequestResponse sendRequest(
	        @WebParam(name = "SendRequestRequest", targetNamespace = Namespaces.TYPES, partName = "parameters") SendRequestRequest parameters)
	        throws AccessDeniedException, AttachmentContentMiscoordinationException, AttachmentSizeLimitExceededException,
	        BusinessDataTypeIsNotSupportedException, DestinationOverflowException, EndOfLifeException, InvalidContentException, InvalidMessageIdFormatException,
	        MessageIsAlreadySentException, QuoteLimitExceededException, RecipientIsNotFoundException, SMEVFailureException, SenderIsNotRegisteredException,
	        SignatureVerificationFaultException, StaleMessageIdException, TransactionCodeInvalidException {
		try {
			return service.sendRequest(parameters);
		} catch (FailureWrapper e) {
			switch (e.getCode()) {
			case "SMEV.InvalidMessagePrimaryContent":
				throw new InvalidContentException(e.getMessage(), null);
			case "SMEV.SignatureVerificationFault":
				throw new SignatureVerificationFaultException(e.getMessage(), null);
			case "SMEV.SenderIsNotRegistered":
				throw new SenderIsNotRegisteredException(e.getMessage(), null);
			case "SMEV.InvalidMessageIdFormat":
				throw new InvalidMessageIdFormatException(e.getMessage(), new Void());
			case "SMEV.MessageIsAlreadySent":
				throw new MessageIsAlreadySentException(e.getMessage(), new Void());
			case "SMEV.BusinessDataTypeIsNotSupported.Unregistered":
				throw new BusinessDataTypeIsNotSupportedException(e.getMessage(), null);
			default:
				log.error(e.toString(), e);
				throw new SMEVFailureException(e.getMessage(), new Void());
			}
		}
	}

	@WebMethod(operationName = "SendResponse", action = "urn:SendResponse")
	@WebResult(name = "SendResponseResponse", targetNamespace = Namespaces.TYPES, partName = "parameters")
	public SendResponseResponse sendResponse(
	        @WebParam(name = "SendResponseRequest", targetNamespace = Namespaces.TYPES, partName = "parameters") SendResponseRequest parameters)
	        throws AttachmentContentMiscoordinationException, AttachmentSizeLimitExceededException, BusinessDataTypeIsNotSupportedException,
	        DestinationOverflowException, IncorrectResponseContentTypeException, InvalidContentException, InvalidMessageIdFormatException,
	        MessageIsAlreadySentException, QuoteLimitExceededException, RecipientIsNotFoundException, SMEVFailureException, SenderIsNotRegisteredException,
	        SignatureVerificationFaultException, StaleMessageIdException {
		try {

			return service.sendResponse(parameters);
		} catch (FailureWrapper e) {
			switch (e.getCode()) {
			case "SMEV.InvalidMessagePrimaryContent":
				throw new InvalidContentException(e.getMessage(), null);
			case "SMEV.RecipientIsNotFound.RequestNotFound":
				throw new RecipientIsNotFoundException(e.getMessage(), new Void());
			case "SMEV.RecipientIsNotFound.UnregisteredRecipient":
				throw new RecipientIsNotFoundException(e.getMessage(), new Void());
			case "SMEV.SignatureVerificationFault":
				throw new SignatureVerificationFaultException(e.getMessage(), null);
			case "SMEV.SenderIsNotRegistered":
				throw new SenderIsNotRegisteredException(e.getMessage(), null);
			case "SMEV.InvalidMessageIdFormat":
				throw new InvalidMessageIdFormatException(e.getMessage(), new Void());
			case "SMEV.MessageIsAlreadySent":
				throw new MessageIsAlreadySentException(e.getMessage(), new Void());
			case "SMEV.BusinessDataTypeIsNotSupported.Unregistered":
				throw new BusinessDataTypeIsNotSupportedException(e.getMessage(), null);
			case "SMEV.BusinessDataTypeIsNotSupported.NotOwner":
				throw new BusinessDataTypeIsNotSupportedException(e.getMessage(), null);
			case "SMEV.IncorrectResponseContentType.InvalidRejectionReasonCode":
				throw new IncorrectResponseContentTypeException(e.getMessage(), null);
			default:
				log.error(e.toString(), e);
				throw new SMEVFailureException(e.getMessage(), new Void());
			}
		}
	}

	@WebMethod(operationName = "GetRequest", action = "urn:GetRequest")
	@WebResult(name = "GetRequestResponse", targetNamespace = Namespaces.TYPES, partName = "parameters")
	public GetRequestResponse getRequest(
	        @WebParam(name = "GetRequestRequest", targetNamespace = Namespaces.TYPES, partName = "parameters") GetRequestRequest parameters)
	        throws InvalidContentException, SMEVFailureException, SenderIsNotRegisteredException, SignatureVerificationFaultException,
	        UnknownMessageTypeException {
		try {

			return service.getRequest(parameters);
		} catch (FailureWrapper e) {
			switch (e.getCode()) {
			case "SMEV.SignatureVerificationFault":
				throw new SignatureVerificationFaultException(e.getMessage(), null);
			case "SMEV.SenderIsNotRegistered":
				throw new SenderIsNotRegisteredException(e.getMessage(), null);
			case "SMEV.AccessDenied.DDOS":
				throw new SenderIsNotRegisteredException(e.getMessage(), null);
			default:
				log.error(e.toString(), e);
				throw new SMEVFailureException(e.getMessage(), new Void());
			}
		}
	}

	@WebMethod(operationName = "GetStatus", action = "urn:GetStatus")
	@WebResult(name = "GetStatusResponse", targetNamespace = Namespaces.TYPES, partName = "parameters")
	public GetStatusResponse getStatus(
	        @WebParam(name = "GetStatusRequest", targetNamespace = Namespaces.TYPES, partName = "parameters") GetStatusRequest parameters)
	        throws InvalidContentException, SMEVFailureException, SenderIsNotRegisteredException, SignatureVerificationFaultException,
	        UnknownMessageTypeException {
		try {
			return service.getStatus(parameters);
		} catch (FailureWrapper e) {
			switch (e.getCode()) {
			case "SMEV.SignatureVerificationFault":
				throw new SignatureVerificationFaultException(e.getMessage(), null);
			case "SMEV.SenderIsNotRegistered":
				throw new SenderIsNotRegisteredException(e.getMessage(), null);
			default:
				log.error(e.toString(), e);
				throw new SMEVFailureException(e.getMessage(), new Void());
			}
		}
	}

	@WebMethod(operationName = "GetResponse", action = "urn:GetResponse")
	@WebResult(name = "GetResponseResponse", targetNamespace = Namespaces.TYPES, partName = "parameters")
	public GetResponseResponse getResponse(
	        @WebParam(name = "GetResponseRequest", targetNamespace = Namespaces.TYPES, partName = "parameters") GetResponseRequest parameters)
	        throws InvalidContentException, SMEVFailureException, SenderIsNotRegisteredException, SignatureVerificationFaultException,
	        UnknownMessageTypeException {
		try {
			return service.getResponse(parameters);
		} catch (FailureWrapper e) {
			switch (e.getCode()) {
			case "SMEV.SignatureVerificationFault":
				throw new SignatureVerificationFaultException(e.getMessage(), null);
			case "SMEV.SenderIsNotRegistered":
				throw new SenderIsNotRegisteredException(e.getMessage(), null);
			case "SMEV.AccessDenied.DDOS":
				throw new SenderIsNotRegisteredException(e.getMessage(), null);
			default:
				log.error(e.toString(), e);
				throw new SMEVFailureException(e.getMessage(), new Void());
			}
		}
	}

	@WebMethod(operationName = "Ack", action = "urn:Ack")
	@WebResult(name = "AckResponse", targetNamespace = Namespaces.TYPES, partName = "parameters")
	public Void ack(@WebParam(name = "AckRequest", targetNamespace = Namespaces.TYPES, partName = "parameters") AckRequest parameters)
	        throws InvalidContentException, SMEVFailureException, SenderIsNotRegisteredException, SignatureVerificationFaultException,
	        TargetMessageIsNotFoundException {
		try {
			return service.ack(parameters);
		} catch (FailureWrapper e) {
			switch (e.getCode()) {
			case "SMEV.SignatureVerificationFault":
				throw new SignatureVerificationFaultException(e.getMessage(), null);
			case "SMEV.TargetMessageIsNotFound":
				throw new TargetMessageIsNotFoundException(e.getMessage(), null);
			default:
				log.error(e.toString(), e);
				throw new SMEVFailureException(e.getMessage(), new Void());
			}
		}
	}

	@WebMethod(operationName = "GetIncomingQueueStatistics", action = "urn:GetIncomingQueueStatistics")
	@WebResult(name = "GetIncomingQueueStatisticsResponse", targetNamespace = Namespaces.TYPES, partName = "parameters")
	public GetIncomingQueueStatisticsResponse getIncomingQueueStatistics(
	        @WebParam(name = "GetIncomingQueueStatisticsRequest", targetNamespace = Namespaces.TYPES, partName = "parameters") GetIncomingQueueStatisticsRequest parameters)
	        throws InvalidContentException, SMEVFailureException, SenderIsNotRegisteredException, SignatureVerificationFaultException {
		try {
			return service.getIncomingQueueStatistics(parameters);
		} catch (FailureWrapper e) {
			switch (e.getCode()) {
			case "SMEV.SignatureVerificationFault":
				throw new SignatureVerificationFaultException(e.getMessage(), null);
			case "SMEV.SenderIsNotRegistered":
				throw new SenderIsNotRegisteredException(e.getMessage(), null);
			default:
				log.error(e.toString(), e);
				throw new SMEVFailureException(e.getMessage(), new Void());
			}
		}
	}

}
