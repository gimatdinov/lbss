package ru.otr.lbss.service.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoDatabase;

import cxc.jex.common.application.config.ConfigService;
import cxc.jex.common.xml.transform.JAXBTransformer;
import ru.otr.lbss.service.config.LbssConfig;
import ru.otr.lbss.service.model.codec.RequestMessageCodec;
import ru.otr.lbss.service.model.codec.ResponseMessageCodec;
import ru.otr.lbss.service.model.codec.SmevMemberCodec;
import ru.otr.lbss.service.model.codec.StatusMessageCodec;

public class DBProvider {
	private static Logger log = LoggerFactory.getLogger(DBProvider.class);

	@Autowired
	private ConfigService configService;
	@Autowired
	private JAXBTransformer transformer;

	private MongoClient client;
	private MongoDatabase messagesDB;
	private MongoDatabase membersDB;

	@PostConstruct
	private void init() {
		log.info("init");
		try {
			Codec<Document> defaultDocumentCodec = MongoClient.getDefaultCodecRegistry().get(Document.class);
			SmevMemberCodec smevMemberCodec = new SmevMemberCodec(defaultDocumentCodec);
			RequestMessageCodec requestMessageCodec = new RequestMessageCodec(defaultDocumentCodec, transformer);
			ResponseMessageCodec responseMessageCodec = new ResponseMessageCodec(defaultDocumentCodec, transformer);
			StatusMessageCodec statusMessageCodec = new StatusMessageCodec(defaultDocumentCodec, transformer);
			CodecRegistry codecRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),
			        CodecRegistries.fromCodecs(smevMemberCodec, requestMessageCodec, responseMessageCodec, statusMessageCodec));
			MongoClientOptions mongoOptions = MongoClientOptions.builder().codecRegistry(codecRegistry).build();
			String mongoHost = configService.getString(LbssConfig.mongo_host);
			int mongoPort = configService.getInteger(LbssConfig.mongo_port, 27017);
			log.info("MongoDB : " + mongoHost + ":" + mongoPort);
			client = new MongoClient(mongoHost + ":" + mongoPort, mongoOptions);
			messagesDB = client.getDatabase(configService.getString(LbssConfig.mongo_db_messages));
			membersDB = client.getDatabase(configService.getString(LbssConfig.mongo_db_members));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@PreDestroy
	private void fina() {
		log.info("fina");
		client.close();
	}

	public MongoDatabase getMessgesDB() {
		return messagesDB;
	}

	public MongoDatabase getMembersDB() {
		return membersDB;
	}

}
