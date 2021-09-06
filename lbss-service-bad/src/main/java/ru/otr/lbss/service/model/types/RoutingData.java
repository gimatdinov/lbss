package ru.otr.lbss.service.model.types;

import java.io.Serializable;

import ru.otr.lbss.client.model.types.MessageMetadata;

public abstract class RoutingData implements Serializable {

    private static final long serialVersionUID = -5727899186588332051L;

    private MpcKey mpcKey;
    private MessageMetadata messageMetadata;

    public MpcKey getMpcKey() {
        return mpcKey;
    }

    public void setMpcKey(MpcKey mpcKey) {
        this.mpcKey = mpcKey;
    }

    public MessageMetadata getMessageMetadata() {
        return messageMetadata;
    }

    public void setMessageMetadata(MessageMetadata messageMetadata) {
        this.messageMetadata = messageMetadata;
    }

}
