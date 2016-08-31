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
import ru.otr.lbss.client.model.types.Response;
import ru.otr.lbss.client.model.types.GetResponseResponse.ResponseMessage;
import ru.otr.lbss.client.model.types.basic.XMLDSigSignatureType;
import ru.otr.lbss.service.model.FieldNames;

public class ResponseMessageCodec implements CollectibleCodec<ResponseMessage> {
	private Codec<Document> documentCodec;
	private DocumentPartsMaker docPartsMaker;
	private MessagePartsMaker msgPartsMaker;
	private JAXBTransformer transformer;

	public ResponseMessageCodec(Codec<Document> documentCodec, JAXBTransformer transformer) throws ExceptionWrapper {
		this.documentCodec = documentCodec;
		this.transformer = transformer;
		docPartsMaker = new DocumentPartsMaker(transformer);
		msgPartsMaker = new MessagePartsMaker(transformer);
	}

	@Override
	public void encode(BsonWriter writer, ResponseMessage src, EncoderContext encoderContext) {
		try {
			Document response = new Document();
			response.append("Id", src.getResponse().getId());
			response.append("OriginalMessageId", src.getResponse().getOriginalMessageId());
			response.append("OriginalTransactionCode", src.getResponse().getOriginalTransactionCode());
			response.append("ReferenceMessageID", src.getResponse().getReferenceMessageID());
			response.append("SenderProvidedResponseData", docPartsMaker.makeSenderProvidedResponseData(src.getResponse().getSenderProvidedResponseData()));
			response.append("MessageMetadata", docPartsMaker.makeMessageMetadata(src.getResponse().getMessageMetadata()));
			if (src.getResponse().getFSAttachmentsList() != null) {
				response.append("FSAttachmentsList", docPartsMaker.makeFSAttachmentsList(src.getResponse().getFSAttachmentsList()));
			}
			if (src.getResponse().getSenderInformationSystemSignature() != null) {
				response.append("SenderInformationSystemSignature", transformer.obj2xml(src.getResponse().getSenderInformationSystemSignature()));
			}

			Document result = new Document();
			result.append("Response", response);
			if (src.getAttachmentContentList() != null) {
				result.append("AttachmentContentList", docPartsMaker.makeAttachmentContentList(
				        src.getResponse().getSenderProvidedResponseData().getAttachmentHeaderList(), src.getAttachmentContentList()));
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
	public ResponseMessage decode(BsonReader reader, DecoderContext decoderContext) {
		try {
			Document doc = documentCodec.decode(reader, decoderContext);
			Response response = new Response();
			Document responseDoc = (Document) doc.get("Response");
			response.setId(responseDoc.getString("Id"));
			response.setOriginalMessageId(responseDoc.getString("OriginalMessageId"));
			response.setOriginalTransactionCode(responseDoc.getString("OriginalTransactionCode"));
			response.setReferenceMessageID(responseDoc.getString("ReferenceMessageID"));
			response.setSenderProvidedResponseData(msgPartsMaker.makeSenderProvidedResponseData((Document) responseDoc.get("SenderProvidedResponseData")));
			response.setMessageMetadata(msgPartsMaker.makeMessageMetadata((Document) responseDoc.get("MessageMetadata")));
			if (responseDoc.get("FSAttachmentsList") != null) {
				response.setFSAttachmentsList(msgPartsMaker.makeFSAttachmentsList((List<Document>) responseDoc.get("FSAttachmentsList")));
			}
			if (responseDoc.getString("SenderInformationSystemSignature") != null) {
				response.setSenderInformationSystemSignature(
				        (XMLDSigSignatureType) transformer.xml2obj(responseDoc.getString("SenderInformationSystemSignature")));
			}

			ResponseMessage result = new ResponseMessage();
			result.setResponse(response);
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
	public Class<ResponseMessage> getEncoderClass() {
		return ResponseMessage.class;
	}

	@Override
	public boolean documentHasId(ResponseMessage responseMessage) {
		return (responseMessage.getDocId() != null);
	}

	@Override
	public ResponseMessage generateIdIfAbsentFromDocument(ResponseMessage responseMessage) {
		if (!documentHasId(responseMessage)) {
			responseMessage.setDocId(UUID.randomUUID());
		}
		return responseMessage;
	}

	@Override
	public BsonValue getDocumentId(ResponseMessage responseMessage) {
		if (!documentHasId(responseMessage)) {
			throw new IllegalStateException("The document does not contain an " + FieldNames.docId);
		}
		return new BsonString(responseMessage.getDocId().toString());
	}

}
