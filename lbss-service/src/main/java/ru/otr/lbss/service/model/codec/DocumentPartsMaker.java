package ru.otr.lbss.service.model.codec;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import cxc.jex.common.exception.ExceptionWrapper;
import cxc.jex.common.xml.transform.JAXBTransformer;
import ru.otr.lbss.client.model.types.AsyncProcessingStatus;
import ru.otr.lbss.client.model.types.MessageMetadata;
import ru.otr.lbss.client.model.types.SenderProvidedRequestData;
import ru.otr.lbss.client.model.types.SenderProvidedResponseData;
import ru.otr.lbss.client.model.types.SenderProvidedResponseData.RequestRejected;
import ru.otr.lbss.client.model.types.SenderProvidedResponseData.RequestStatus;
import ru.otr.lbss.client.model.types.SenderProvidedResponseData.RequestStatus.StatusParameter;
import ru.otr.lbss.client.model.types.basic.AttachmentContentList;
import ru.otr.lbss.client.model.types.basic.AttachmentContentType;
import ru.otr.lbss.client.model.types.basic.AttachmentHeaderList;
import ru.otr.lbss.client.model.types.basic.AttachmentHeaderType;
import ru.otr.lbss.client.model.types.basic.FSAttachmentsList;
import ru.otr.lbss.client.model.types.basic.FSAuthInfo;
import ru.otr.lbss.client.model.types.basic.RefAttachmentHeaderList;
import ru.otr.lbss.client.model.types.basic.RefAttachmentHeaderType;
import ru.otr.lbss.client.model.types.basic.SmevFault;

public class DocumentPartsMaker {

	private JAXBTransformer transformer;

	public DocumentPartsMaker(JAXBTransformer transformer) {
		this.transformer = transformer;
	}

	private List<Document> makeAttachmentHeaderList(AttachmentHeaderList attachList) {
		List<Document> result = new ArrayList<>();
		for (AttachmentHeaderType item : attachList.getAttachmentHeader()) {
			Document attachDoc = new Document();
			attachDoc.append("ContentId", item.getContentId());
			attachDoc.append("MimeType", item.getMimeType());
			if (item.getSignaturePKCS7() != null) {
				attachDoc.append("SignaturePKCS7", item.getSignaturePKCS7());
			}
			result.add(attachDoc);
		}
		return result;
	}

	private List<Document> makeRefAttachmentHeaderList(RefAttachmentHeaderList attachList) {
		List<Document> result = new ArrayList<>();
		for (RefAttachmentHeaderType item : attachList.getRefAttachmentHeader()) {
			Document attachDoc = new Document();
			attachDoc.append("Uuid", item.getUuid());
			attachDoc.append("Hash", item.getHash());
			attachDoc.append("MimeType", item.getMimeType());
			if (item.getSignaturePKCS7() != null) {
				attachDoc.append("SignaturePKCS7", item.getSignaturePKCS7());
			}
			result.add(attachDoc);
		}
		return result;
	}

	public List<Document> makeAttachmentContentList(AttachmentHeaderList attachList, AttachmentContentList contentList) throws ExceptionWrapper {
		try {
			List<Document> result = new ArrayList<>();
			for (AttachmentContentType item : contentList.getAttachmentContent()) {
				Document contentDoc = new Document();
				contentDoc.append("Id", item.getId());
				for (AttachmentHeaderType entry : attachList.getAttachmentHeader()) {
					if (entry.getContentId() == item.getId()) {
						contentDoc.append("MimeType", entry.getMimeType());
						break;
					}
				}
				ByteArrayOutputStream content = new ByteArrayOutputStream();
				item.getContent().writeTo(content);
				contentDoc.append("Content", content.toByteArray());
				result.add(contentDoc);
			}
			return result;
		} catch (IOException e) {
			throw new ExceptionWrapper(e);
		}
	}

	public Document makeSenderProvidedRequestData(SenderProvidedRequestData spreqd) throws ExceptionWrapper {
		Document result = new Document();
		if (spreqd.getId() != null) {
			result.append("Id", spreqd.getId());
		}
		result.append("MessageID", spreqd.getMessageID());
		result.append("ReferenceMessageID", spreqd.getReferenceMessageID());
		result.append("TransactionCode", spreqd.getTransactionCode());
		if (spreqd.getNodeID() != null) {
			result.append("NodeID", spreqd.getNodeID());
		}
		if (spreqd.getEOL() != null) {
			result.append("EOL", spreqd.getEOL().toXMLFormat());
		}
		if (spreqd.getMessagePrimaryContent() != null) {
			result.append("MessagePrimaryContent", transformer.obj2xml(spreqd.getMessagePrimaryContent()));
		}
		if (spreqd.getPersonalSignature() != null) {
			result.append("PersonalSignature", transformer.obj2xml(spreqd.getPersonalSignature()));
		}
		if (spreqd.getAttachmentHeaderList() != null) {
			result.append("AttachmentHeaderList", makeAttachmentHeaderList(spreqd.getAttachmentHeaderList()));
		}
		if (spreqd.getRefAttachmentHeaderList() != null) {
			result.append("RefAttachmentHeaderList", makeRefAttachmentHeaderList(spreqd.getRefAttachmentHeaderList()));
		}
		if (spreqd.getBusinessProcessMetadata() != null) {
			result.append("BusinessProcessMetadata", transformer.obj2xml(spreqd.getBusinessProcessMetadata()));
		}
		if (spreqd.getTestMessage() != null) {
			result.append("TestMessage", true);
		}
		return result;
	}

	private List<Document> makeRequestRejected(List<RequestRejected> requestRejecteds) {
		List<Document> result = new ArrayList<>();
		for (RequestRejected item : requestRejecteds) {
			result.add(new Document("RejectionReasonCode", item.getRejectionReasonCode().toString()).append("RejectionReasonDescription",
			        item.getRejectionReasonDescription()));
		}
		return result;
	}

	private List<Document> makeStatusParameter(List<StatusParameter> statusParameters) {
		List<Document> result = new ArrayList<>();
		for (StatusParameter item : statusParameters) {
			result.add(new Document("Key", item.getKey()).append("Value", item.getValue()));
		}
		return result;
	}

	private Document makeRequestStatus(RequestStatus requestStatus) {
		Document result = new Document();
		result.append("StatusCode", requestStatus.getStatusCode());
		if (requestStatus.getStatusParameter().size() > 0) {
			result.append("StatusParameter", makeStatusParameter(requestStatus.getStatusParameter()));
		}
		result.append("StatusDescription", requestStatus.getStatusDescription());
		return result;
	}

	public Document makeAsyncProcessingStatus(AsyncProcessingStatus asyncProcessingStatus) {
		Document result = new Document();
		result.append("OriginalMessageId", asyncProcessingStatus.getOriginalMessageId());
		if (asyncProcessingStatus.getStatusCategory() != null) {
			result.append("StatusCategory", asyncProcessingStatus.getStatusCategory().toString());
		}
		if (asyncProcessingStatus.getStatusDetails() != null) {
			result.append("StatusDetails", asyncProcessingStatus.getStatusDetails());
		}
		if (asyncProcessingStatus.getSmevFault() != null) {
			result.append("SmevFault", makeSmevFault(asyncProcessingStatus.getSmevFault()));
		}
		return result;
	}

	private Document makeSmevFault(SmevFault smevFault) {
		Document result = new Document();
		if (smevFault.getCode() != null) {
			result.append("Code", smevFault.getCode());
		}
		if (smevFault.getDescription() != null) {
			result.append("Description", smevFault.getDescription());
		}
		return result;
	}

	public Document makeSenderProvidedResponseData(SenderProvidedResponseData spresd) throws ExceptionWrapper {
		Document result = new Document();
		if (spresd.getId() != null) {
			result.append("Id", spresd.getId());
		}
		result.append("MessageID", spresd.getMessageID());
		result.append("To", spresd.getTo());
		if (spresd.getMessagePrimaryContent() != null) {
			result.append("MessagePrimaryContent", transformer.obj2xml(spresd.getMessagePrimaryContent()));
		}
		if (spresd.getPersonalSignature() != null) {
			result.append("PersonalSignature", transformer.obj2xml(spresd.getPersonalSignature()));
		}
		if (spresd.getAttachmentHeaderList() != null) {
			result.append("AttachmentHeaderList", makeAttachmentHeaderList(spresd.getAttachmentHeaderList()));
		}
		if (spresd.getRefAttachmentHeaderList() != null) {
			result.append("RefAttachmentHeaderList", makeRefAttachmentHeaderList(spresd.getRefAttachmentHeaderList()));
		}
		if (spresd.getRequestRejected().size() > 0) {
			result.append("RequestRejected", makeRequestRejected(spresd.getRequestRejected()));
		}
		if (spresd.getRequestStatus() != null) {
			result.append("RequestStatus", makeRequestStatus(spresd.getRequestStatus()));
		}
		if (spresd.getAsyncProcessingStatus() != null) {
			result.append("AsyncProcessingStatus", makeAsyncProcessingStatus(spresd.getAsyncProcessingStatus()));
		}

		return result;
	}

	public Document makeMessageMetadata(MessageMetadata metadata) throws ExceptionWrapper {
		Document result = new Document();
		result.append("Id", metadata.getId());
		result.append("MessageId", metadata.getMessageId());
		result.append("MessageType", metadata.getMessageType().toString());
		result.append("Sender",
		        new Document("Mnemonic", metadata.getSender().getMnemonic()).append("HumanReadableName", metadata.getSender().getHumanReadableName()));
		result.append("SendingTimestamp", metadata.getSendingTimestamp().toGregorianCalendar().getTime());
		//result.append("DestinationName", metadata.getDestinationName());
		if (metadata.getRecipient() != null) {
			result.append("Recipient", new Document("Mnemonic", metadata.getRecipient().getMnemonic()).append("HumanReadableName",
			        metadata.getRecipient().getHumanReadableName()));
		}
		/*Document supplementaryDataDoc = new Document("InteractionType", metadata.getSupplementaryData().getInteractionType().toString());
		if (metadata.getSupplementaryData().getDetectedContentTypeName() != null) {
			supplementaryDataDoc.append("DetectedContentTypeName", metadata.getSupplementaryData().getDetectedContentTypeName());
		}
		result.append("SupplementaryData", supplementaryDataDoc);*/
		if (metadata.getDeliveryTimestamp() != null) {
			result.append("DeliveryTimestamp", metadata.getDeliveryTimestamp().toGregorianCalendar().getTime());
		}
		if (metadata.getStatus() != null) {
			result.append("Status", metadata.getStatus().toString());
		}
		return result;
	}

	public List<Document> makeFSAttachmentsList(FSAttachmentsList attachList) {
		List<Document> result = new ArrayList<>();
		for (FSAuthInfo item : attachList.getFSAttachment()) {
			Document attachDoc = new Document();
			attachDoc.append("Uuid", item.getUuid());
			attachDoc.append("UserName", item.getUserName());
			attachDoc.append("Password", item.getPassword());
			attachDoc.append("FileName", item.getFileName());
			result.add(attachDoc);
		}
		return result;
	}

}
