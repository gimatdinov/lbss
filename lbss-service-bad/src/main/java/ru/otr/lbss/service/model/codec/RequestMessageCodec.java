package ru.otr.lbss.service.model.codec;

import java.util.List;
import java.util.UUID;

import org.bson.BsonReader;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

import cxc.jex.common.exception.ExceptionWrapper;
import cxc.jex.common.xml.transform.JAXBTransformer;
import ru.otr.lbss.client.model.types.Request;
import ru.otr.lbss.client.model.types.GetRequestResponse.RequestMessage;
import ru.otr.lbss.client.model.types.basic.XMLDSigSignatureType;
import ru.otr.lbss.service.model.FieldNames;

public class RequestMessageCodec implements CollectibleCodec<RequestMessage> {

	private Codec<Document> documentCodec;
	private DocumentPartsMaker docPartsMaker;
	private MessagePartsMaker msgPartsMaker;
	private JAXBTransformer transformer;

	public RequestMessageCodec(Codec<Document> documentCodec, JAXBTransformer transformer) throws ExceptionWrapper {
		this.documentCodec = documentCodec;
		this.transformer = transformer;
		docPartsMaker = new DocumentPartsMaker(transformer);
		msgPartsMaker = new MessagePartsMaker(transformer);
	}

	@Override
	public void encode(BsonWriter writer, RequestMessage src, EncoderContext encoderContext) {
		try {
			Document request = new Document();
			request.append("Id", src.getRequest().getId());
			request.append("SenderProvidedRequestData", docPartsMaker.makeSenderProvidedRequestData(src.getRequest().getSenderProvidedRequestData()));
			request.append("MessageMetadata", docPartsMaker.makeMessageMetadata(src.getRequest().getMessageMetadata()));
			if (src.getRequest().getFSAttachmentsList() != null) {
				request.append("FSAttachmentsList", docPartsMaker.makeFSAttachmentsList(src.getRequest().getFSAttachmentsList()));
			}
			request.append("ReplyTo", src.getRequest().getReplyTo());
			if (src.getRequest().getSenderInformationSystemSignature() != null) {
				request.append("SenderInformationSystemSignature", transformer.obj2xml(src.getRequest().getSenderInformationSystemSignature()));
			}

			Document result = new Document();

			result.append("Request", request);
			if (src.getAttachmentContentList() != null) {
				result.append("AttachmentContentList", docPartsMaker
				        .makeAttachmentContentList(src.getRequest().getSenderProvidedRequestData().getAttachmentHeaderList(), src.getAttachmentContentList()));
			}
			if (src.getSMEVSignature() != null) {
				result.append("SMEVSignature", transformer.obj2xml(src.getSMEVSignature()));
			}

			result.append(FieldNames.docId, src.getDocId().toString());
			result.append(FieldNames.mpcNamespace, src.getMpcNamespace());
			result.append(FieldNames.mpcRootElement, src.getMpcRootElement());
			result.append(FieldNames.acknowledgmentTimestamp, src.getAcknowledgmentTimestamp());

			documentCodec.encode(writer, result, encoderContext);
		} catch (ExceptionWrapper e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public RequestMessage decode(BsonReader reader, DecoderContext decoderContext) {
		try {
			Document doc = documentCodec.decode(reader, decoderContext);
			Request request = new Request();
			Document requestDoc = (Document) doc.get("Request");
			request.setId(requestDoc.getString("Id"));
			request.setSenderProvidedRequestData(msgPartsMaker.makeSenderProvidedRequestData((Document) requestDoc.get("SenderProvidedRequestData")));
			request.setMessageMetadata(msgPartsMaker.makeMessageMetadata((Document) requestDoc.get("MessageMetadata")));
			if (requestDoc.get("FSAttachmentsList") != null) {
				request.setFSAttachmentsList(msgPartsMaker.makeFSAttachmentsList((List<Document>) requestDoc.get("FSAttachmentsList")));
			}
			request.setReplyTo(requestDoc.getString("ReplyTo"));
			if (requestDoc.getString("SenderInformationSystemSignature") != null) {
				request.setSenderInformationSystemSignature((XMLDSigSignatureType) transformer.xml2obj(requestDoc.getString("SenderInformationSystemSignature")));
			}

			RequestMessage result = new RequestMessage();
			result.setRequest(request);
			if (doc.get("AttachmentContentList") != null) {
				result.setAttachmentContentList(msgPartsMaker.makeAttachmentContentList((List<Document>) doc.get("AttachmentContentList")));
			}
			if (doc.get("SMEVSignature") != null) {
				result.setSMEVSignature((XMLDSigSignatureType) transformer.xml2obj(doc.getString("SMEVSignature")));
			}
			result.setDocId(UUID.fromString(doc.getString(FieldNames.docId)));
			result.setMpcNamespace(doc.getString(FieldNames.mpcNamespace));
			result.setMpcRootElement(doc.getString(FieldNames.mpcRootElement));
			result.setAcknowledgmentTimestamp(doc.getLong(FieldNames.acknowledgmentTimestamp));

			return result;
		} catch (ExceptionWrapper e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Class<RequestMessage> getEncoderClass() {
		return RequestMessage.class;
	}

	@Override
	public boolean documentHasId(RequestMessage requestMessage) {
		return (requestMessage.getDocId() != null);
	}

	@Override
	public RequestMessage generateIdIfAbsentFromDocument(RequestMessage requestMessage) {
		if (!documentHasId(requestMessage)) {
			requestMessage.setDocId(UUID.randomUUID());
		}
		return requestMessage;
	}

	@Override
	public BsonValue getDocumentId(RequestMessage requestMessage) {
		if (!documentHasId(requestMessage)) {
			throw new IllegalStateException("The RequestMessage does not contain an 'docId'.");
		}
		return new BsonString(requestMessage.getDocId().toString());
	}

}
