package ru.otr.lbss;

import javax.annotation.PostConstruct;

import org.jolokia.http.AgentServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import cxc.jex.common.application.config.SpringPropertiesService;
import cxc.jex.common.application.config.PropertiesService;
import cxc.jex.common.application.message.ApplicationMessageService;
import cxc.jex.common.application.message.SpringApplicationMessageService;
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
	@Autowired
	ApplicationMessageService msgService;

	@PostConstruct
	private void init() {
		log.info("init");
	}

	@Bean
	PropertiesService propertiesService() {
		return new SpringPropertiesService(environment);
	}

	@Bean
	ApplicationMessageService applicationMessageService() {
		return new SpringApplicationMessageService();
	}

	@Bean
	public ServletRegistrationBean jolokiaServletRegistrationBean() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new AgentServlet(), "/jolokia/*");
		registration.setName("JolokiaAgent");
		return registration;
	}

}
