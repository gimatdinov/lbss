package ru.otr.lbss.model.codec;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.activation.DataHandler;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.bson.Document;
import org.bson.types.Binary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cxc.jex.common.exception.ExceptionWrapper;
import cxc.jex.common.xml.transform.JAXBTransformer;
import ru.otr.lbss.ws.api.types.AsyncProcessingStatus;
import ru.otr.lbss.ws.api.types.MessageMetadata;
import ru.otr.lbss.ws.api.types.MessageTypeType;
import ru.otr.lbss.ws.api.types.RejectCode;
import ru.otr.lbss.ws.api.types.SenderProvidedRequestData;
import ru.otr.lbss.ws.api.types.SenderProvidedRequestData.BusinessProcessMetadata;
import ru.otr.lbss.ws.api.types.SenderProvidedResponseData;
import ru.otr.lbss.ws.api.types.SenderProvidedResponseData.RequestRejected;
import ru.otr.lbss.ws.api.types.SenderProvidedResponseData.RequestStatus;
import ru.otr.lbss.ws.api.types.basic.AttachmentContentList;
import ru.otr.lbss.ws.api.types.basic.AttachmentContentType;
import ru.otr.lbss.ws.api.types.basic.AttachmentHeaderList;
import ru.otr.lbss.ws.api.types.basic.AttachmentHeaderType;
import ru.otr.lbss.ws.api.types.basic.FSAttachmentsList;
import ru.otr.lbss.ws.api.types.basic.FSAuthInfo;
import ru.otr.lbss.ws.api.types.basic.InteractionStatusType;
import ru.otr.lbss.ws.api.types.basic.InteractionTypeType;
import ru.otr.lbss.ws.api.types.basic.MessagePrimaryContent;
import ru.otr.lbss.ws.api.types.basic.RefAttachmentHeaderList;
import ru.otr.lbss.ws.api.types.basic.RefAttachmentHeaderType;
import ru.otr.lbss.ws.api.types.basic.SmevFault;
import ru.otr.lbss.ws.api.types.basic.Void;
import ru.otr.lbss.ws.api.types.basic.XMLDSigSignatureType;

public class MessagePartsMaker {
    private static Logger log = LoggerFactory.getLogger(MessagePartsMaker.class);

    private JAXBTransformer transformer;
    private DatatypeFactory datatypeFactory;

    public MessagePartsMaker(JAXBTransformer transformer) throws ExceptionWrapper {
        try {
            this.transformer = transformer;
            datatypeFactory = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e) {
            throw new ExceptionWrapper(e);
        }
    }

    private AttachmentHeaderList makeAttachmentHeaderList(List<Document> docList) throws ExceptionWrapper {
        AttachmentHeaderList result = new AttachmentHeaderList();
        for (Document item : docList) {
            AttachmentHeaderType attach = new AttachmentHeaderType();
            attach.setContentId(item.getString("ContentId"));
            attach.setMimeType(item.getString("MimeType"));
            if (item.get("SignaturePKCS7") != null) {
                Binary sign = (Binary) item.get("SignaturePKCS7");
                attach.setSignaturePKCS7(sign.getData());
            }
            result.getAttachmentHeader().add(attach);
        }
        return result;
    }

    private RefAttachmentHeaderList makeRefAttachmentHeaderList(List<Document> docList) throws ExceptionWrapper {

        RefAttachmentHeaderList result = new RefAttachmentHeaderList();
        for (Document item : docList) {
            RefAttachmentHeaderType attach = new RefAttachmentHeaderType();
            attach.setUuid(item.getString("Uuid"));
            attach.setHash(item.getString("Hash"));
            attach.setMimeType(item.getString("MimeType"));
            if (item.get("SignaturePKCS7") != null) {
                Binary sign = (Binary) item.get("SignaturePKCS7");
                attach.setSignaturePKCS7(sign.getData());
            }
            result.getRefAttachmentHeader().add(attach);
        }
        return result;
    }

    public AttachmentContentList makeAttachmentContentList(List<Document> docList) throws ExceptionWrapper {
        AttachmentContentList result = new AttachmentContentList();
        for (Document item : docList) {
            AttachmentContentType attach = new AttachmentContentType();
            attach.setId(item.getString("Id"));
            Binary content = (Binary) item.get("Content");
            attach.setContent(new DataHandler(content.getData(), item.getString("MimeType")));
            result.getAttachmentContent().add(attach);
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public SenderProvidedRequestData makeSenderProvidedRequestData(Document doc) throws ExceptionWrapper {
        SenderProvidedRequestData result = new SenderProvidedRequestData();
        result.setId(doc.getString("Id"));
        result.setMessageID(doc.getString("MessageID"));
        result.setReferenceMessageID(doc.getString("ReferenceMessageID"));
        result.setTransactionCode(doc.getString("TransactionCode"));
        if (doc.get("NodeID") != null) {
            result.setNodeID(doc.getString("NodeID"));
        }
        if (doc.get("EOL") != null) {
            result.setEOL(datatypeFactory.newXMLGregorianCalendar(doc.getString("EOL")));
        }
        if (doc.get("MessagePrimaryContent") != null) {
            String mpc = doc.getString("MessagePrimaryContent");
            if (mpc.length() == 0) {
                // TODO Ошибка, иногда сохраняется пустой MessagePrimaryContent
                // (возможно ошибка старой java 1.8_65)
                log.error("Пустой MessagePrimaryContent, MessageID=" + result.getMessageID());
            }
            result.setMessagePrimaryContent((MessagePrimaryContent) transformer.xml2obj(mpc));
        }
        if (doc.get("PersonalSignature") != null) {
            result.setPersonalSignature((XMLDSigSignatureType) transformer.xml2obj(doc.getString("PersonalSignature")));
        }
        if (doc.get("AttachmentHeaderList") != null) {
            result.setAttachmentHeaderList(makeAttachmentHeaderList((List<Document>) doc.get("AttachmentHeaderList")));
        }
        if (doc.get("RefAttachmentHeaderList") != null) {
            result.setRefAttachmentHeaderList(makeRefAttachmentHeaderList((List<Document>) doc.get("RefAttachmentHeaderList")));
        }
        if (doc.getString("BusinessProcessMetadata") != null) {
            result.setBusinessProcessMetadata((BusinessProcessMetadata) transformer.xml2obj(doc.getString("BusinessProcessMetadata")));
        }
        if (doc.get("TestMessage") != null) {
            result.setTestMessage(new Void());
        }
        return result;
    }

    private List<RequestRejected> makeRequestRejected(List<Document> docList) {
        List<RequestRejected> result = new ArrayList<>();
        for (Document item : docList) {
            RequestRejected reject = new RequestRejected();
            if (item.get("RejectionReasonCode") != null) {
                reject.setRejectionReasonCode(RejectCode.valueOf(item.getString("RejectionReasonCode")));
            }
            reject.setRejectionReasonDescription(item.getString("RejectionReasonDescription"));
            result.add(reject);
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    private RequestStatus makeRequestStatus(Document doc) {
        RequestStatus result = new RequestStatus();
        result.setStatusCode(doc.getInteger("StatusCode"));
        if (doc.get("StatusParameter") != null) {
            List<Document> paramDocs = (List<Document>) doc.get("StatusParameter");
            for (Document item : paramDocs) {
                SenderProvidedResponseData.RequestStatus.StatusParameter param = new SenderProvidedResponseData.RequestStatus.StatusParameter();
                param.setKey(item.getString("Key"));
                param.setValue(item.getString("Value"));
                result.getStatusParameter().add(param);
            }
        }
        result.setStatusDescription(doc.getString("StatusDescription"));
        return result;
    }

    public AsyncProcessingStatus makeAsyncProcessingStatus(Document doc) {
        AsyncProcessingStatus result = new AsyncProcessingStatus();
        result.setOriginalMessageId(doc.getString("OriginalMessageId"));
        if (doc.get("StatusCategory") != null) {
            result.setStatusCategory(InteractionStatusType.valueOf(doc.getString("StatusCategory")));
        }
        if (doc.get("StatusDetails") != null) {
            result.setStatusDetails(doc.getString("StatusDetails"));
        }
        if (doc.get("SmevFault") != null) {
            result.setSmevFault(makeSmevFault((Document) doc.get("SmevFault")));
        }
        return result;
    }

    private SmevFault makeSmevFault(Document doc) {
        SmevFault result = new SmevFault();
        result.setCode(doc.getString("Code"));
        result.setDescription(doc.getString("Description"));
        return result;
    }

    @SuppressWarnings("unchecked")
    public SenderProvidedResponseData makeSenderProvidedResponseData(Document doc) throws ExceptionWrapper {
        SenderProvidedResponseData result = new SenderProvidedResponseData();
        result.setId(doc.getString("Id"));
        result.setMessageID(doc.getString("MessageID"));
        result.setTo(doc.getString("To"));
        if (doc.getString("MessagePrimaryContent") != null) {
            result.setMessagePrimaryContent((MessagePrimaryContent) transformer.xml2obj(doc.getString("MessagePrimaryContent")));
        }
        if (doc.getString("PersonalSignature") != null) {
            result.setPersonalSignature((XMLDSigSignatureType) transformer.xml2obj(doc.getString("PersonalSignature")));
        }
        if (doc.get("AttachmentHeaderList") != null) {
            result.setAttachmentHeaderList(makeAttachmentHeaderList((List<Document>) doc.get("AttachmentHeaderList")));
        }
        if (doc.get("RefAttachmentHeaderList") != null) {
            result.setRefAttachmentHeaderList(makeRefAttachmentHeaderList((List<Document>) doc.get("RefAttachmentHeaderList")));
        }
        if (doc.get("RequestRejected") != null) {
            result.getRequestRejected().addAll(makeRequestRejected((List<Document>) doc.get("RequestRejected")));
        }
        if (doc.get("RequestStatus") != null) {
            result.setRequestStatus(makeRequestStatus((Document) doc.get("RequestStatus")));
        }
        if (doc.get("AsyncProcessingStatus") != null) {
            result.setAsyncProcessingStatus(makeAsyncProcessingStatus((Document) doc.get("AsyncProcessingStatus")));
        }
        return result;
    }

    public MessageMetadata makeMessageMetadata(Document doc) {
        MessageMetadata result = new MessageMetadata();
        result.setId(doc.getString("Id"));
        result.setMessageId(doc.getString("MessageId"));
        result.setMessageType(MessageTypeType.valueOf(doc.getString("MessageType")));

        Document senderDoc = (Document) doc.get("Sender");
        result.setSender(new MessageMetadata.Sender());
        result.getSender().setMnemonic(senderDoc.getString("Mnemonic"));
        result.getSender().setHumanReadableName(senderDoc.getString("HumanReadableName"));
        GregorianCalendar sendingTimestamp = new GregorianCalendar();
        sendingTimestamp.setTime(doc.getDate("SendingTimestamp"));
        result.setSendingTimestamp(datatypeFactory.newXMLGregorianCalendar(sendingTimestamp));
        result.setDestinationName(doc.getString("DestinationName"));

        if (doc.get("Recipient") != null) {
            Document recipientDoc = (Document) doc.get("Recipient");
            result.setRecipient(new MessageMetadata.Recipient());
            result.getRecipient().setMnemonic(recipientDoc.getString("Mnemonic"));
            result.getRecipient().setHumanReadableName(recipientDoc.getString("HumanReadableName"));
        }

        Document supplementaryDataDoc = (Document) doc.get("SupplementaryData");
        result.setSupplementaryData(new MessageMetadata.SupplementaryData());
        if (supplementaryDataDoc.get("DetectedContentTypeName") != null) {
            result.getSupplementaryData().setDetectedContentTypeName(supplementaryDataDoc.getString("DetectedContentTypeName"));
        }
        result.getSupplementaryData().setInteractionType(InteractionTypeType.valueOf(supplementaryDataDoc.getString("InteractionType")));

        if (doc.get("DeliveryTimestamp") != null) {
            GregorianCalendar deliveryTimestamp = new GregorianCalendar();
            sendingTimestamp.setTime(doc.getDate("DeliveryTimestamp"));
            result.setDeliveryTimestamp(datatypeFactory.newXMLGregorianCalendar(deliveryTimestamp));
        }

        if (doc.get("Status") != null) {
            result.setStatus(InteractionStatusType.valueOf(doc.getString("Status")));
        }
        return result;
    }

    public FSAttachmentsList makeFSAttachmentsList(List<Document> docList) {
        FSAttachmentsList result = new FSAttachmentsList();
        for (Document item : docList) {
            FSAuthInfo attach = new FSAuthInfo();
            attach.setUuid(item.getString("Uuid"));
            attach.setUserName(item.getString("UserName"));
            attach.setPassword(item.getString("Password"));
            attach.setFileName(item.getString("FileName"));
            result.getFSAttachment().add(attach);
        }
        return result;
    }

}
