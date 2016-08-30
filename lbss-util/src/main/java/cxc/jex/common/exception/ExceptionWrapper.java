package cxc.jex.common.exception;

import cxc.jex.common.application.message.ApplicationMessageHelper;

public class ExceptionWrapper extends Exception {

	private static final long serialVersionUID = -708551873877520364L;

	private static final ApplicationMessageHelper msgHelper = new ApplicationMessageHelper();

	public static final String PROMPT = "Exception";

	private String code = "unknown";

	public static ApplicationMessageHelper getMessageHelper() {
		return msgHelper;
	}

	public ExceptionWrapper() {
		super("[" + PROMPT + ":unknown]");
	}

	public ExceptionWrapper(Throwable cause) {
		super("[" + PROMPT + ":RAW] " + cause.getMessage(), cause);
	}

	public ExceptionWrapper(String code) {
		super("[" + PROMPT + ":" + code + "] " + msgHelper.findMessage(code));
		this.code = code;
	}

	public ExceptionWrapper(String code, Throwable cause) {
		super("[" + PROMPT + ":" + code + "] " + msgHelper.findMessage(code), cause);
		this.code = code;
	}

	public ExceptionWrapper(String code, Object... parameters) {
		super("[" + PROMPT + ":" + code + "] " + String.format(msgHelper.findMessage(code), parameters));
		this.code = code;
	}

	public ExceptionWrapper(String code, Throwable cause, Object... parameters) {
		super("[" + PROMPT + ":" + code + "] " + String.format(msgHelper.findMessage(code), parameters), cause);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
