package ru.otr.lbss.service;

import javax.annotation.PostConstruct;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import cxc.jex.common.failure.FailureWrapper;
import ru.otr.lbss.client.model.types.basic.XMLDSigSignatureType;
import ru.otr.lbss.service.model.DocNames;
import ru.otr.lbss.service.model.ModelConstants;
import ru.otr.lbss.service.model.ModelFilters;
import ru.otr.lbss.service.model.types.SmevMember;

public class SmevValidationService {
    private static Logger log = LoggerFactory.getLogger(SmevValidationService.class);

    @Autowired
    @Qualifier("messagesDB")
    private MongoDatabase messagesDB;
    @Autowired
    private SmevMemberService memberService;

    @PostConstruct
    private void init() {
        log.info("init SmevValidationService");

    }

    public SmevMember checkCallerInformationSystemSignature(XMLDSigSignatureType ciss) throws FailureWrapper {
        if (ciss == null || ciss.getAny() == null) {
            throw new FailureWrapper("SMEV.SignatureVerificationFault");
        }
        SmevMember member = memberService.findMember(ciss.getAny());
        if (member == null) {
            throw new FailureWrapper("SMEV.SenderIsNotRegistered", "Хэш сертификата = " +memberService.getCertificateHash());
        }
        return member;
    }

    public void checkMessageID(String messageID) throws FailureWrapper {
        if (messageID == null || !messageID.trim().matches(ModelConstants.UUID_REGEXP)) {
            throw new FailureWrapper("SMEV.InvalidMessageIdFormat");
        }

        MongoCollection<Document> requestMessageDocs = messagesDB.getCollection(DocNames.RequestMessage);
        if (requestMessageDocs.find(ModelFilters.forRequestMessageID(messageID)).first() != null) {
            throw new FailureWrapper("SMEV.MessageIsAlreadySent");
        }
        MongoCollection<Document> responseMessageDocs = messagesDB.getCollection(DocNames.ResponseMessage);
        if (responseMessageDocs.find(ModelFilters.forResponseMessageID(messageID)).first() != null) {
            throw new FailureWrapper("SMEV.MessageIsAlreadySent");
        }
    }
}
