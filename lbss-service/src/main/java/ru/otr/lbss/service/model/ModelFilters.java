package ru.otr.lbss.service.model;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.lt;

import org.bson.conversions.Bson;

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
