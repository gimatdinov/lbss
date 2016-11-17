package cxc.jex.common.application.message;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cxc.jex.common.exception.ExceptionWrapper;
import cxc.jex.common.failure.FailureWrapper;

public class SpringApplicationMessageService implements ApplicationMessageService {
	private static Logger log = LoggerFactory.getLogger(ApplicationMessageService.class);

	private static final String PROPERTIES_FILE = "/application-messages.properties";
	private Properties messages;

	@PostConstruct
	public void init() {
		log.info("init");
		messages = new Properties();
		try {
			InputStream in = getClass().getResourceAsStream(PROPERTIES_FILE);
			if (in != null) {
				messages.load(in);
				in.close();
				log.info("Load " + PROPERTIES_FILE + " : " + messages.getProperty("__OK"));

				ApplicationMessageSource msgSource = new ApplicationMessageSource() {

					@Override
					public String getMessage(String code) {
						return __getMessage(code);
					}
				};
				ExceptionWrapper.getMessageHelper().registerMessageSource(msgSource);
				FailureWrapper.getMessageHelper().registerMessageSource(msgSource);
			} else {
				log.warn("File is not found: " + PROPERTIES_FILE);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private String __getMessage(String code) {
		return messages.getProperty(code);
	}

	@Override
	public String getMessage(String code) {
		return messages.getProperty(code);
	}

	@Override
	public String getMessage(String code, Object... args) {
		return String.format(messages.getProperty(code), args);
	}

}
