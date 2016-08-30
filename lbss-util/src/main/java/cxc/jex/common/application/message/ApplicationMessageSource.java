package cxc.jex.common.application.message;

public abstract class ApplicationMessageSource {

	public abstract String getMessage(String code);
	
	public String getMessage(String code, Object... args) {
		return String.format(getMessage(code), args);
	}

}
