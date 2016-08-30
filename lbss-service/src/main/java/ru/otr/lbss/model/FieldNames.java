package ru.otr.lbss.model;

public interface FieldNames {
    // BaseMessage
    static final String docId = "_id";

    // InformationMessage
    static final String mpcNamespace = "MessagePrimaryContentNamespace";
    static final String mpcRootElement = "MessagePrimaryContentRootElement";
    static final String acknowledgmentTimestamp = "acknowledgmentTimestamp";

    // StatusMessage
    static final String delivered = "delivered";
}
