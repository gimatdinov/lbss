package ru.otr.lbss.service.model.types;

import java.io.Serializable;

public class ResponseRoutingData extends RoutingData implements Serializable {
    private static final long serialVersionUID = 2354773144099685111L;

    public static enum ResponseKind {
        MessagePrimaryContent, RequestRejected, RequestStatus, AsyncProcessingStatus
    }

    private String _To;
    private ResponseKind kind;

    public String getTo() {
        return _To;
    }

    public void setTo(String value) {
        this._To = value.trim();
    }

    public ResponseKind getKind() {
        return kind;
    }

    public void setKind(ResponseKind kind) {
        this.kind = kind;
    }

}
