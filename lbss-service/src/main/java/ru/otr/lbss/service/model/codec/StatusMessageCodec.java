package ru.otr.lbss.service.model.codec;

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
import ru.otr.lbss.client.model.types.AsyncProcessingStatusData;
import ru.otr.lbss.client.model.types.SmevAsyncProcessingMessage;
import ru.otr.lbss.client.model.types.MessageMetadata.Recipient;
import ru.otr.lbss.client.model.types.basic.XMLDSigSignatureType;
import ru.otr.lbss.service.model.FieldNames;

public class StatusMessageCodec implements CollectibleCodec<SmevAsyncProcessingMessage> {
	private Codec<Document> documentCodec;
	private DocumentPartsMaker docPartsMaker;
	private MessagePartsMaker msgPartsMaker;
	private JAXBTransformer transformer;

	public StatusMessageCodec(Codec<Document> documentCodec, JAXBTransformer transformer) throws ExceptionWrapper {
		this.documentCodec = documentCodec;
		this.transformer = transformer;
		docPartsMaker = new DocumentPartsMaker(transformer);
		msgPartsMaker = new MessagePartsMaker(transformer);

	}

	@Override
	public void encode(BsonWriter writer, SmevAsyncProcessingMessage src, EncoderContext encoderContext) {
		try {
			Document statusData = new Document();
			statusData.append("Id", src.getAsyncProcessingStatusData().getId());
			statusData.append("AsyncProcessingStatus", docPartsMaker.makeAsyncProcessingStatus(src.getAsyncProcessingStatusData().getAsyncProcessingStatus()));

			Document recipient = new Document();
			recipient.append("Mnemonic", src.getRecipient().getMnemonic());
			recipient.append("HumanReadableName", src.getRecipient().getHumanReadableName());

			Document result = new Document();
			result.append("AsyncProcessingStatusData", statusData);
			result.append("Recipient", recipient);

			if (src.getSMEVSignature() != null) {
				result.append("SMEVSignature", transformer.obj2xml(src.getSMEVSignature()));
			}

			result.append(FieldNames.docId, src.getDocId().toString());
			result.append(FieldNames.delivered, src.isDelivered());

			documentCodec.encode(writer, result, encoderContext);
		} catch (ExceptionWrapper e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public SmevAsyncProcessingMessage decode(BsonReader reader, DecoderContext decoderContext) {
		try {
			Document doc = documentCodec.decode(reader, decoderContext);

			AsyncProcessingStatusData statusData = new AsyncProcessingStatusData();
			Document statusDataDoc = (Document) doc.get("AsyncProcessingStatusData");
			statusData.setId(statusDataDoc.getString("Id"));
			statusData.setAsyncProcessingStatus(msgPartsMaker.makeAsyncProcessingStatus((Document) statusDataDoc.get("AsyncProcessingStatus")));

			Document recipientDoc = (Document) doc.get("Recipient");
			Recipient recipient = new Recipient();
			recipient.setMnemonic(recipientDoc.getString("Mnemonic"));
			recipient.setHumanReadableName(recipientDoc.getString("HumanReadableName"));

			SmevAsyncProcessingMessage result = new SmevAsyncProcessingMessage();
			result.setAsyncProcessingStatusData(statusData);
			result.setRecipient(recipient);

			if (doc.get("SMEVSignature") != null) {
				result.setSMEVSignature((XMLDSigSignatureType) transformer.xml2obj(doc.getString("SMEVSignature")));
			}

			result.setDocId(UUID.fromString(doc.getString(FieldNames.docId)));
			result.setDelivered(doc.getBoolean(FieldNames.delivered, false));

			return result;
		} catch (ExceptionWrapper e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Class<SmevAsyncProcessingMessage> getEncoderClass() {
		return SmevAsyncProcessingMessage.class;
	}

	@Override
	public boolean documentHasId(SmevAsyncProcessingMessage statusMessage) {
		return (statusMessage.getDocId() != null);
	}

	@Override
	public SmevAsyncProcessingMessage generateIdIfAbsentFromDocument(SmevAsyncProcessingMessage statusMessage) {
		if (!documentHasId(statusMessage)) {
			statusMessage.setDocId(UUID.randomUUID());
		}
		return statusMessage;
	}

	@Override
	public BsonValue getDocumentId(SmevAsyncProcessingMessage statusMessage) {
		if (!documentHasId(statusMessage)) {
			throw new IllegalStateException("The StatusMessage does not contain an 'docId'.");
		}
		return new BsonString(statusMessage.getDocId().toString());
	}

}
