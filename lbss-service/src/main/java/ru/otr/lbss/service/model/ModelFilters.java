package ru.otr.lbss.service.model;

import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.*;

public class ModelFilters {

    public static Bson forRequestMessageID(String messageID) {
        return eq("Request.MessageMetadata.MessageId", messageID.trim().toLowerCase());
    }

    public static Bson forResponseMessageID(String messageID) {
        return eq("Response.MessageMetadata.MessageId", messageID.trim().toLowerCase());
    }

    public static Bson forMPC(String mpcNamespace, String mpcRootElement) {
        return and(eq(FieldNames.mpcNamespace, mpcNamespace), eq(FieldNames.mpcRootElement, mpcRootElement));
    }

    public static Bson forAcknowledgment(long acknowledgmentTimeout) {
        return lt(FieldNames.acknowledgmentTimestamp, System.currentTimeMillis() - acknowledgmentTimeout);
    }
}
