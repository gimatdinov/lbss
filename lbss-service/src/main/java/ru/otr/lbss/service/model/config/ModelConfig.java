package ru.otr.lbss.service.model.config;

import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoDatabase;

import cxc.jex.common.application.config.PropertiesService;
import cxc.jex.common.exception.ExceptionWrapper;
import cxc.jex.common.xml.transform.JAXBTransformer;
import ru.otr.lbss.service.model.codec.RequestMessageCodec;
import ru.otr.lbss.service.model.codec.ResponseMessageCodec;
import ru.otr.lbss.service.model.codec.SmevMemberCodec;
import ru.otr.lbss.service.model.codec.StatusMessageCodec;

@Configuration
public class ModelConfig {
    private static Logger log = LoggerFactory.getLogger(ModelConfig.class);

    @Autowired
    PropertiesService propertiesService;

    @Lazy
    @Autowired
    JAXBTransformer transformer;

    @Bean
    JAXBTransformer getJAXBTransformer() {
        try {
            return new JAXBTransformer(propertiesService.getString(ModelProperties.jaxb_context_path), false);
        } catch (ExceptionWrapper e) {
            throw new RuntimeException(e);
        }
    }

    @Lazy
    @Autowired
    MongoClient mongoClient;

    @Lazy
    @Bean
    MongoClient getMongoClient() {
        try {
            Codec<Document> defaultDocumentCodec = MongoClient.getDefaultCodecRegistry().get(Document.class);
            SmevMemberCodec smevMemberCodec = new SmevMemberCodec(defaultDocumentCodec);
            RequestMessageCodec requestMessageCodec = new RequestMessageCodec(defaultDocumentCodec, transformer);
            ResponseMessageCodec responseMessageCodec = new ResponseMessageCodec(defaultDocumentCodec, transformer);
            StatusMessageCodec statusMessageCodec = new StatusMessageCodec(defaultDocumentCodec, transformer);
            CodecRegistry codecRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),
                    CodecRegistries.fromCodecs(smevMemberCodec, requestMessageCodec, responseMessageCodec, statusMessageCodec));
            MongoClientOptions mongoOptions = MongoClientOptions.builder().codecRegistry(codecRegistry).build();
            String mongoHost = propertiesService.getString(ModelProperties.mongo_host);
            int mongoPort = propertiesService.getInteger(ModelProperties.mongo_port, 27017);
            log.info("MongoDB : " + mongoHost + ":" + mongoPort);
            return new MongoClient(mongoHost + ":" + mongoPort, mongoOptions);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Lazy
    @Bean(name = "messagesDB")
    MongoDatabase getMessagesDB() {
        return mongoClient.getDatabase(propertiesService.getString(ModelProperties.mongo_db_messages));
    }

    @Lazy
    @Bean(name = "membersDB")
    MongoDatabase getMembersDB() {
        return mongoClient.getDatabase(propertiesService.getString(ModelProperties.mongo_db_members));
    }

}
