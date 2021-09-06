package ru.otr.lbss.client.api;

import cxc.jex.common.failure.FailureWrapper;
import ru.otr.lbss.client.model.types.AckRequest;
import ru.otr.lbss.client.model.types.GetRequestRequest;
import ru.otr.lbss.client.model.types.GetRequestResponse;
import ru.otr.lbss.client.model.types.GetResponseRequest;
import ru.otr.lbss.client.model.types.GetResponseResponse;
import ru.otr.lbss.client.model.types.GetStatusRequest;
import ru.otr.lbss.client.model.types.GetStatusResponse;
import ru.otr.lbss.client.model.types.SendRequestRequest;
import ru.otr.lbss.client.model.types.SendRequestResponse;
import ru.otr.lbss.client.model.types.SendResponseRequest;
import ru.otr.lbss.client.model.types.SendResponseResponse;
import ru.otr.lbss.client.model.types.basic.Void;

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

}
