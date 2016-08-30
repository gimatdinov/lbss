package ru.otr.lbss.model;

import java.io.Serializable;

public class ResponseRoutingData extends RoutingData implements Serializable {
    private static final long serialVersionUID = 2354773144099685111L;

    private String _To;

    public String getTo() {
        return _To;
    }

    public void setTo(String value) {
        this._To = value.trim();
    }

}
