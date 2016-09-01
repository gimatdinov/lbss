package ru.otr.lbss.config;

import org.jolokia.http.AgentServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by tartanov.mikhail on 29.08.2016.
 */
@Component
@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean jolokiaServletRegistrationBean() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new AgentServlet(), "/jolokia/*");
        registration.setName("JolokiaAgent");
        return registration;
    }
}
