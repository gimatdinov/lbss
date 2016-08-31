package ru.otr.lbss;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import cxc.jex.common.application.config.PropertiesService;
import cxc.jex.common.application.message.ApplicationMessageService;
import ru.otr.lbss.service.config.ServiceConfig;
import ru.otr.lbss.web.config.WebConfig;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { MongoAutoConfiguration.class })
@Import({ ServiceConfig.class, WebConfig.class })
@PropertySource("classpath:application.properties")
public class LbssApplication {
    private static Logger log = LoggerFactory.getLogger(LbssApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LbssApplication.class, args);
    }

    @Autowired
    Environment environment;

    @Bean
    PropertiesService getPropertiesService() {
        return new LbssPropertiesService(environment);
    }

    @Bean
    ApplicationMessageService getApplicationMessageService() {
        return new LbssApplicationMessageService();

    }

}
