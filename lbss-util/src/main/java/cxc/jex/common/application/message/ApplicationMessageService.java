package cxc.jex.common.application.message;

public interface ApplicationMessageService {
	
	void init();
	
    String getMessage(String code);

    String getMessage(String code, Object... args);
}
