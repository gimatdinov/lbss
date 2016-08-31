package cxc.jex.common.application.config;

public interface PropertiesService {

	String getString(String key);

	String getString(String key, String defaultValue);

	Integer getInteger(String key);

	Integer getInteger(String key, int defaultValue);

	Long getLong(String key);

	Long getLong(String key, long defaultValue);

	Boolean getBoolean(String key);

	Boolean getBoolean(String key, boolean defaultValue);
}
