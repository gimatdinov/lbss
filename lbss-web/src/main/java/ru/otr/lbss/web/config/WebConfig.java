package ru.otr.lbss.web.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cxc.jex.common.application.config.PropertiesService;
import ru.otr.lbss.web.ws.SMEVMessageExchange;

@Configuration
public class WebConfig {
    private static Logger log = LoggerFactory.getLogger(WebConfig.class);

    @Autowired
    PropertiesService propertiesService;

    @Bean
    public SMEVMessageExchange getSMEVMessageExchange() {
        return new SMEVMessageExchange();
    }

    @Bean
    public Endpoint endpoint() {
        log.info("SMEVMessageExchangeService URI : " + propertiesService.getString(WebProperties.WebServices_URI)
                + propertiesService.getString(WebProperties.SMEVMessageExchangeService_endpoint));
        EndpointImpl endpoint = new EndpointImpl(getSpringBus(), getSMEVMessageExchange());
        //javax.xml.ws.soap.SOAPBinding binding = (javax.xml.ws.soap.SOAPBinding)endpoint.getBinding();
        //binding.setMTOMEnabled(true);
        endpoint.publish(propertiesService.getString(WebProperties.SMEVMessageExchangeService_endpoint));
        return endpoint;
    }

    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), propertiesService.getString(WebProperties.WebServices_URI) + "/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus getSpringBus() {
        return new SpringBus();
    }
}
