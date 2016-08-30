package cxc.jex.common.application.message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationMessageHelper {

	private Map<String, String> internalMsgStore;
	private Map<String, String> internalMsgAuthorStore;
	private ApplicationMessageSource internalMsgSource;
	private List<ApplicationMessageSource> msgSources;

	public ApplicationMessageHelper() {
		internalMsgStore = new HashMap<>();
		internalMsgAuthorStore = new HashMap<>();
		internalMsgSource = new ApplicationMessageSource() {

			@Override
			public String getMessage(String code) {
				return internalMsgStore.get(code);
			}
		};
		msgSources = new ArrayList<>();
		msgSources.add(internalMsgSource);
	}

	public synchronized void registerMessageSource(ApplicationMessageSource src) {
		if (msgSources.contains(src)) {
			throw new RuntimeException("ApplicationMessageSource [" + src + "] is already registered!");
		}
		msgSources.add(src);
	}

	public synchronized void registerMessage(String code, String msg, String author) {
		if (internalMsgStore.get(code) != null) {
			throw new RuntimeException("Message for code=" + code + " is already registered by [" + internalMsgAuthorStore.get(code) + "]");
		}
		internalMsgStore.put(code, msg);
		internalMsgAuthorStore.put(code, author);
	}
	
	public String findMessage(String code) {
		for (ApplicationMessageSource item : msgSources) {
			String msg = item.getMessage(code);
			if (msg != null) {
				return msg;
			}
		}
		return "";
	}
}
