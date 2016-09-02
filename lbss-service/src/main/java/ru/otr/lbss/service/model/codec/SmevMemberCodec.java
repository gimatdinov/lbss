package ru.otr.lbss.service.model.codec;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.BsonReader;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.types.ObjectId;

import ru.otr.lbss.service.model.FieldNames;
import ru.otr.lbss.service.model.types.MpcKey;
import ru.otr.lbss.service.model.types.SmevMember;

public class SmevMemberCodec implements CollectibleCodec<SmevMember> {
    private Codec<Document> documentCodec;

    public SmevMemberCodec(Codec<Document> documentCodec) {
        this.documentCodec = documentCodec;
    }

    @Override
    public void encode(BsonWriter writer, SmevMember src, EncoderContext encoderContext) {
        Document doc = new Document();
        doc.append(FieldNames.docId, src.getMnemonic());
        doc.append("Mnemonic", src.getMnemonic());
        doc.append("HumanReadableName", src.getHumanReadableName());
        doc.append("Type", src.getType().toString());
        doc.append("FtpUserPassword", src.getFtpUserPassword());
        doc.append("CertificateHash", src.getCertificateHash());

        List<Document> mpcRegistrationDocList = new ArrayList<>();
        for (MpcKey item : src.getMpcRegistrationList()) {
            mpcRegistrationDocList.add(item.toDocument());
        }
        doc.append("MpcRegistrationList", mpcRegistrationDocList);
        documentCodec.encode(writer, doc, encoderContext);
    }

    @Override
    public Class<SmevMember> getEncoderClass() {
        return SmevMember.class;
    }

    @SuppressWarnings("unchecked")
    @Override
    public SmevMember decode(BsonReader reader, DecoderContext decoderContext) {
        Document doc = documentCodec.decode(reader, decoderContext);
        SmevMember result = new SmevMember(doc.getString("Mnemonic"), doc.getString("HumanReadableName"));
        result.setType(SmevMember.Type.valueOf(doc.getString("Type")));
        result.setFtpUserPassword(doc.getString("FtpUserPassword"));
        result.setCertificateHash(doc.getString("CertificateHash"));

        List<Document> mpcRegistrationDocList = (List<Document>) doc.get("MpcRegistrationList");
        for (Document item : mpcRegistrationDocList) {
        	result.getMpcRegistrationList().add(new MpcKey(item));
        }
        return result;
    }

    @Override
    public boolean documentHasId(SmevMember member) {
        return (member.getMnemonic() != null && member.getMnemonic().length() > 0);
    }

    @Override
    public SmevMember generateIdIfAbsentFromDocument(SmevMember member) {
        if (!documentHasId(member)) {
            member.setMnemonic("member_" + new ObjectId(new Date()).toHexString());
        }
        return member;
    }

    @Override
    public BsonValue getDocumentId(SmevMember member) {
        if (!documentHasId(member)) {
            throw new IllegalStateException("The SmevMember does not contain an 'Mnemonic'.");
        }
        return new BsonString(member.getMnemonic());
    }

}
