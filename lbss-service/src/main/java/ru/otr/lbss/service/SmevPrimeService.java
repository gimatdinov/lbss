package ru.otr.lbss.service;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cxc.jex.common.exception.ExceptionWrapper;
import cxc.jex.common.failure.FailureWrapper;
import ru.otr.lbss.client.api.*;
import ru.otr.lbss.client.model.types.*;
import ru.otr.lbss.client.model.types.basic.InteractionStatusType;
import ru.otr.lbss.client.model.types.basic.Void;
import ru.otr.lbss.service.antiddos.AntiDDOS;
import ru.otr.lbss.service.config.ModeService;
import ru.otr.lbss.service.model.types.RequestRoutingData;
import ru.otr.lbss.service.model.types.ResponseRoutingData;
import ru.otr.lbss.service.model.types.ResponseRoutingData.ResponseKind;
import ru.otr.lbss.service.model.types.SmevMember;

public class SmevPrimeService implements SmevPrimeServiceLocal {
	private static Logger log = LoggerFactory.getLogger(SmevPrimeService.class);

	@Autowired
	private ModeService modeService;
	@Autowired
	private SmevValidationService validationService;
	@Autowired
	private SmevProcessingService processingService;
	@Autowired
	private SmevSignService signService;
	@Autowired
	private AntiDDOS antiDDOS;

	@PostConstruct
	private void init() {
		log.info("init");
	}

	@Override
	public Mode getMode() {
		return modeService.getPrimeServiceMode();
	}

	@Override
	public SendRequestResponse sendRequest(SendRequestRequest request) throws FailureWrapper {
		SmevMember sender = validationService.checkCallerInformationSystemSignature(request.getCallerInformationSystemSignature());
		RequestRoutingData routingData = processingService.makeRoutingData(request, sender);
		// TODO проверка запроса
		validationService.checkMessageID(request.getSenderProvidedRequestData().getMessageID());
		boolean async = (request.getSenderProvidedRequestData().getRefAttachmentHeaderList() != null);
		if (async) {
			routingData.getMessageMetadata().setStatus(InteractionStatusType.REQUEST_IS_QUEUED);
		} else {
			routingData.getMessageMetadata().setStatus(InteractionStatusType.REQUEST_IS_ACCEPTED_BY_SMEV);
		}
		SendRequestResponse response = new SendRequestResponse();
		response.setMessageMetadata(routingData.getMessageMetadata());
		try {
			signService.signSMEVSignature(response);
		} catch (ExceptionWrapper e) {
			throw new FailureWrapper(e);
		}
		if (getMode() == Mode.LIVE) {
			processingService.putRequest(request, routingData, async);
		}
		return response;
	}

	@Override
	public SendResponseResponse sendResponse(SendResponseRequest request) throws FailureWrapper {
		SmevMember sender = validationService.checkCallerInformationSystemSignature(request.getCallerInformationSystemSignature());
		ResponseRoutingData routingData = processingService.makeRoutingData(request, sender);
		if (routingData.getKind() == ResponseKind.RequestRejected) {
			for (SenderProvidedResponseData.RequestRejected reject : request.getSenderProvidedResponseData().getRequestRejected()) {
				if (reject.getRejectionReasonCode() == null) {
					throw new FailureWrapper("SMEV.IncorrectResponseContentType.InvalidRejectionReasonCode", Arrays.toString(RejectCode.values()));
				}
			}
		}
		// TODO проверка ответа
		validationService.checkMessageID(request.getSenderProvidedResponseData().getMessageID());
		boolean async = (request.getSenderProvidedResponseData().getRefAttachmentHeaderList() != null);
		if (async) {
			routingData.getMessageMetadata().setStatus(InteractionStatusType.REQUEST_IS_QUEUED);
		} else {
			routingData.getMessageMetadata().setStatus(InteractionStatusType.RESPONSE_IS_ACCEPTED_BY_SMEV);
		}
		SendResponseResponse response = new SendResponseResponse();
		response.setMessageMetadata(routingData.getMessageMetadata());
		try {
			signService.signSMEVSignature(response);
		} catch (ExceptionWrapper e) {
			throw new FailureWrapper(e);
		}
		if (getMode() == Mode.LIVE) {
			processingService.putResponse(request, routingData, async);
		}
		return response;
	}

	@Override
	public GetRequestResponse getRequest(GetRequestRequest request) throws FailureWrapper {
		SmevMember recipient = validationService.checkCallerInformationSystemSignature(request.getCallerInformationSystemSignature());
		antiDDOS.checkGetRequest(recipient, System.currentTimeMillis());
		GetRequestResponse response = new GetRequestResponse();
		response.setRequestMessage(processingService.getRequest(request, recipient));
		if (response.getRequestMessage() != null) {
			antiDDOS.resetGetRequest(recipient);
		}
		return response;
	}

	@Override
	public GetResponseResponse getResponse(GetResponseRequest request) throws FailureWrapper {
		SmevMember recipient = validationService.checkCallerInformationSystemSignature(request.getCallerInformationSystemSignature());
		antiDDOS.checkGetResponse(recipient, System.currentTimeMillis());
		GetResponseResponse response = new GetResponseResponse();
		response.setResponseMessage(processingService.getResponse(request, recipient));
		if (response.getResponseMessage() != null) {
			antiDDOS.resetGetResponse(recipient);
		}
		return response;
	}

	@Override
	public GetStatusResponse getStatus(GetStatusRequest request) throws FailureWrapper {
		SmevMember sender = validationService.checkCallerInformationSystemSignature(request.getCallerInformationSystemSignature());
		GetStatusResponse response = new GetStatusResponse();
		response.setSmevAsyncProcessingMessage(processingService.getStatus(request, sender));
		return response;
	}

	@Override
	public Void ack(AckRequest request) throws FailureWrapper {
		SmevMember sender = validationService.checkCallerInformationSystemSignature(request.getCallerInformationSystemSignature());
		String messageID = request.getAckTargetMessage().getValue();
		if (getMode() == Mode.FROZEN && processingService.findRequest(messageID, sender) == null && processingService.findResponse(messageID, sender) == null) {
			throw new FailureWrapper("SMEV.TargetMessageIsNotFound", messageID);
		}
		try {
			if (getMode() == Mode.LIVE && !processingService.ackRequest(messageID, sender) && !processingService.ackResponse(messageID, sender)) {
				throw new FailureWrapper("SMEV.TargetMessageIsNotFound", messageID);
			}
		} catch (ExceptionWrapper e) {
			throw new FailureWrapper(e);
		}
		return new Void();
	}

	@Override
	public GetIncomingQueueStatisticsResponse getIncomingQueueStatistics(GetIncomingQueueStatisticsRequest request) throws FailureWrapper {
		SmevMember sender = validationService.checkCallerInformationSystemSignature(request.getCallerInformationSystemSignature());
		GetIncomingQueueStatisticsResponse response = new GetIncomingQueueStatisticsResponse();
		response.getQueueStatistics().addAll(processingService.getIncomingQueueStatistics(request, sender));
		return response;
	}

}
