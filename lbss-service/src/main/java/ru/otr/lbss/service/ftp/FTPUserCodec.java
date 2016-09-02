package ru.otr.lbss.service.ftp;

import java.util.Date;

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

public class FTPUserCodec implements CollectibleCodec<FTPUser> {
    private Codec<Document> documentCodec;
    private final String ftpDirectory;

    public FTPUserCodec(Codec<Document> documentCodec, String ftpDirectory) {
        this.documentCodec = documentCodec;
        this.ftpDirectory = ftpDirectory;
    }

    @Override
    public void encode(BsonWriter writer, FTPUser user, EncoderContext encoderContext) {
        Document doc = new Document();
        doc.append("_id", user.getName());
        doc.append("Password", user.getPassword());
        doc.append("Folder", user.getFolder());
        doc.append("WritePermission", user.isWritePermission());
        doc.append("Enabled", user.getEnabled());
        documentCodec.encode(writer, doc, encoderContext);
    }

    @Override
    public FTPUser decode(BsonReader reader, DecoderContext decoderContext) {
        Document doc = documentCodec.decode(reader, decoderContext);
        FTPUser user = new FTPUser(doc.getString("_id"), doc.getString("Password"), ftpDirectory, doc.getString("Folder"),
                doc.getBoolean("WritePermission", false));
        user.setEnabled(doc.getBoolean("Enabled", true));
        return user;
    }

    @Override
    public Class<FTPUser> getEncoderClass() {
        return FTPUser.class;
    }

    @Override
    public FTPUser generateIdIfAbsentFromDocument(FTPUser user) {
        if (!documentHasId(user)) {
            user.setName("user_" + new ObjectId(new Date()).toHexString());
        }
        return user;
    }

    @Override
    public boolean documentHasId(FTPUser user) {
        return (user.getName() != null && user.getName().length() > 0);
    }

    @Override
    public BsonValue getDocumentId(FTPUser user) {
        if (!documentHasId(user)) {
            throw new IllegalStateException("The User does not contain an 'Name'.");
        }
        return new BsonString(user.getName());
    }

}
