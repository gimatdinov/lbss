package ru.otr.lbss;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import cxc.jex.common.application.config.ConfigService;
import cxc.jex.common.application.message.ApplicationMessageService;
import cxc.jex.common.exception.ExceptionWrapper;
import cxc.jex.common.xml.transform.JAXBTransformer;
import ru.otr.lbss.model.mongodb.LbssDBProvider;
import ru.otr.lbss.service.SmevFTPService;
import ru.otr.lbss.service.SmevMemberService;
import ru.otr.lbss.service.SmevPrimeService;
import ru.otr.lbss.service.SmevProcessingService;
import ru.otr.lbss.service.SmevSignService;
import ru.otr.lbss.service.SmevValidationService;
import ru.otr.lbss.service.api.SmevPrimeServiceLocal;
import ru.otr.lbss.service.config.LbssConfig;
import ru.otr.lbss.service.config.LbssConfigService;
import ru.otr.lbss.service.config.LbssModeService;
import ru.otr.lbss.ws.SMEVMessageExchange;

@SpringBootApplication
@PropertySource("classpath:LbssApplication.properties")
public class LbssApplication {
	private static Logger log = LoggerFactory.getLogger(LbssApplication.class);

	final static String WebServices_URI = "LBSS.web.WebServices_URI";
	final static String SMEVMessageExchangeService_endpoint = "LBSS.web.SMEVMessageExchangeService_endpoint";

	public static void main(String[] args) {
		SpringApplication.run(LbssApplication.class, args);
	}

	@Autowired
	Environment environment;

	@Bean
	ConfigService getConfigService() {
		return new LbssConfigService(environment);
	}

	@Bean
	ApplicationMessageService getApplicationMessageService() {
		return new LbssApplicationMessageService();

	}

	@Bean
	JAXBTransformer getJAXBTransformer() {
		try {
			return new JAXBTransformer(environment.getProperty(LbssConfig.jaxb_context_path), false);
		} catch (ExceptionWrapper e) {
			throw new RuntimeException(e);
		}
	}

	@Bean
	SmevPrimeServiceLocal getSmevPrimeService() {
		return new SmevPrimeService();
	};

	@Bean
	LbssModeService getModeService() {
		return new LbssModeService();
	};

	@Bean
	LbssDBProvider getDBProvider() {
		return new LbssDBProvider();
	};

	@Bean
	SmevMemberService getSmevMemberService() {
		return new SmevMemberService();
	}

	@Bean
	SmevSignService getSmevSignService() {
		return new SmevSignService();
	};

	@Bean
	SmevFTPService getSmevFTPService() {
		return new SmevFTPService();
	};

	@Bean
	SmevProcessingService getSmevProcessingService() {
		return new SmevProcessingService();
	}

	@Bean
	SmevValidationService getSmevValidationService() {
		return new SmevValidationService();
	}

	@Bean
	public SMEVMessageExchange getSMEVMessageExchange() {
		return new SMEVMessageExchange();
	}

	@Bean
	public Endpoint endpoint() {
		log.info("SMEVMessageExchangeService URI : " + environment.getProperty(WebServices_URI) + environment.getProperty(SMEVMessageExchangeService_endpoint));
		EndpointImpl endpoint = new EndpointImpl(getSpringBus(), getSMEVMessageExchange());
		endpoint.publish(environment.getProperty(SMEVMessageExchangeService_endpoint));
		return endpoint;
	}

	@Bean
	public ServletRegistrationBean dispatcherServlet() {
		return new ServletRegistrationBean(new CXFServlet(), environment.getProperty(WebServices_URI) + "/*");
	}

	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus getSpringBus() {
		return new SpringBus();
	}
}
