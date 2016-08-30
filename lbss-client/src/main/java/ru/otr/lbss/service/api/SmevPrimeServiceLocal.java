package ru.otr.lbss.service.api;

import cxc.jex.common.failure.FailureWrapper;
import ru.otr.lbss.ws.api.types.AckRequest;
import ru.otr.lbss.ws.api.types.GetIncomingQueueStatisticsRequest;
import ru.otr.lbss.ws.api.types.GetIncomingQueueStatisticsResponse;
import ru.otr.lbss.ws.api.types.GetRequestRequest;
import ru.otr.lbss.ws.api.types.GetRequestResponse;
import ru.otr.lbss.ws.api.types.GetResponseRequest;
import ru.otr.lbss.ws.api.types.GetResponseResponse;
import ru.otr.lbss.ws.api.types.GetStatusRequest;
import ru.otr.lbss.ws.api.types.GetStatusResponse;
import ru.otr.lbss.ws.api.types.SendRequestRequest;
import ru.otr.lbss.ws.api.types.SendRequestResponse;
import ru.otr.lbss.ws.api.types.SendResponseRequest;
import ru.otr.lbss.ws.api.types.SendResponseResponse;
import ru.otr.lbss.ws.api.types.basic.Void;

public interface SmevPrimeServiceLocal {
	public static enum Mode {
		LIVE, FROZEN
	}

	Mode getMode();

	SendRequestResponse sendRequest(SendRequestRequest request) throws FailureWrapper;

	SendResponseResponse sendResponse(SendResponseRequest request) throws FailureWrapper;

	GetStatusResponse getStatus(GetStatusRequest request) throws FailureWrapper;

	GetRequestResponse getRequest(GetRequestRequest request) throws FailureWrapper;

	GetResponseResponse getResponse(GetResponseRequest request) throws FailureWrapper;

	Void ack(AckRequest request) throws FailureWrapper;

	GetIncomingQueueStatisticsResponse getIncomingQueueStatistics(GetIncomingQueueStatisticsRequest request) throws FailureWrapper;

}
