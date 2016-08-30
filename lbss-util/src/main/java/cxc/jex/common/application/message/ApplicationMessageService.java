package cxc.jex.common.application.message;

public interface ApplicationMessageService {
    String getMessage(String code);

    String getMessage(String code, Object... args);
}
