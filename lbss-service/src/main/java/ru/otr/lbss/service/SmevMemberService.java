package ru.otr.lbss.service;

import static com.mongodb.client.model.Filters.eq;

import java.math.BigInteger;
import java.security.MessageDigest;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import cxc.jex.common.exception.ExceptionWrapper;
import cxc.jex.common.failure.FailureWrapper;
import cxc.jex.common.xml.dsig.CertificateHelper;
import cxc.jex.common.xml.dsig.SignatureProtector;
import ru.otr.lbss.service.config.ModeService;
import ru.otr.lbss.service.model.DocNames;
import ru.otr.lbss.service.model.types.MpcKey;
import ru.otr.lbss.service.model.types.SmevMember;

public class SmevMemberService {
	private static Logger log = LoggerFactory.getLogger(SmevMemberService.class);

	public static enum Mode {
		LIVE, STUB
	}

	@Autowired
	private ModeService modeService;
	@Autowired
	@Qualifier("membersDB")
	private MongoDatabase membersDB;
	@Autowired
	private SmevFTPService ftpService;

	private SignatureProtector protector;
	private CertificateHelper certificateHelper;
	private MessageDigest messageDigest;

	@PostConstruct
	private void init() {
		log.info("init");
		try {
			protector = new SignatureProtector();
			certificateHelper = new CertificateHelper();
			messageDigest = MessageDigest.getInstance("MD5");

			if (modeService.getMemberServiceMode() == Mode.STUB) {
				MongoCollection<SmevMember> collection = membersDB.getCollection(DocNames.SmevMember, SmevMember.class);
				SmevMember member = new SmevMember("STUB", "Тестовое ведомство");
				member.setFtpUserPassword("STUB");
				member.setCertificateHash(md5("STUB".getBytes()));
				member.setType(SmevMember.Type.OIV);
				collection.insertOne(member);
			}

			updateFTPUsers();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@PreDestroy
	private void fina() {
		log.info("fina");
	}

	private String md5(byte[] data) {
		BigInteger bigInt = new BigInteger(1, messageDigest.digest(data));
		String result = bigInt.toString(16);
		while (result.length() < 32) {
			result = "0" + result;
		}
		return result;
	}

	private void updateFTPUsers() throws ExceptionWrapper {
		MongoCollection<SmevMember> collection = membersDB.getCollection(DocNames.SmevMember, SmevMember.class);
		MongoCursor<SmevMember> cursor = collection.find().iterator();
		while (cursor.hasNext()) {
			ftpService.saveUser(cursor.next());
		}
	}

	public SmevMember findMember(String mnemonic) {
		MongoCollection<SmevMember> collection = membersDB.getCollection(DocNames.SmevMember, SmevMember.class);
		return collection.find(eq("Mnemonic", mnemonic)).first();
	}

	public SmevMember findMember(Node packedSignature) throws FailureWrapper {
		if (modeService.getMemberServiceMode() == Mode.STUB) {
			return findMember("STUB");
		}
		try {
			Document signature = protector.unpackSignature(packedSignature);
			byte[] certificate = certificateHelper.findSingleCertificate(signature);
			String certificateHash = md5(certificate);
			log.info("findMember : certificateHash=" + certificateHash);
			MongoCollection<SmevMember> collection = membersDB.getCollection(DocNames.SmevMember, SmevMember.class);
			return collection.find(eq("CertificateHash", certificateHash)).first();
		} catch (ExceptionWrapper e) {
			throw new FailureWrapper("SMEV.SignatureVerificationFault");
		}
	}

	public SmevMember findMember(MpcKey mpcKey) {
		if (modeService.getMemberServiceMode() == Mode.STUB) {
			return findMember("STUB");
		}
		log.info("findMember : " + mpcKey);
		MongoCollection<SmevMember> collection = membersDB.getCollection(DocNames.SmevMember, SmevMember.class);
		org.bson.Document fields = new org.bson.Document("$elemMatch", mpcKey.toDocument());
		org.bson.Document filter = new org.bson.Document("MpcRegistrationList", fields);
		return collection.find(filter).first();
	}

}
