package cxc.jex.common.failure;

import cxc.jex.common.application.message.ApplicationMessageHelper;
import cxc.jex.common.exception.ExceptionWrapper;

public class FailureWrapper extends Exception {

	private static final long serialVersionUID = 1318499164843627593L;

	private static final ApplicationMessageHelper msgHelper = new ApplicationMessageHelper();

	public static final String PROMPT = "Failure";
	public static final String CODE_Exception = "Exception";
	public static final String CODE_ExceptionWrapper = "ExceptionWrapper";

	private String code = "unknown";
	private Object[] parameters;

	public static ApplicationMessageHelper getMessageHelper() {
		return msgHelper;
	}

	public FailureWrapper(Throwable cause) {
		super(cause);
		if (cause instanceof ExceptionWrapper) {
			this.code = CODE_ExceptionWrapper;
		} else {
			this.code = CODE_Exception;
		}
	}

	public FailureWrapper(String code) {
		super("[" + PROMPT + ":" + code + "] " + msgHelper.findMessage(code));
		this.code = code;
	}

	public FailureWrapper(String code, String additionText) {
		super("[" + PROMPT + ":" + code + "] " + msgHelper.findMessage(code) + " " + additionText);
		this.code = code;
	}

	public FailureWrapper(String code, Object... parameters) {
		super("[" + PROMPT + ":" + code + "] " + String.format(msgHelper.findMessage(code), parameters));
		this.code = code;
		this.parameters = parameters;
	}

	public String getCode() {
		return code;
	}

	public Object[] getParameters() {
		return parameters;
	}

}
