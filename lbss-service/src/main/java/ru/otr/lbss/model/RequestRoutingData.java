package ru.otr.lbss.model;

import java.io.Serializable;

public class RequestRoutingData extends RoutingData implements Serializable {
    private static final long serialVersionUID = -9092543169570598131L;

    private String replyTo;

    public String getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

}
