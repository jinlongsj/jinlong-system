package com.jinlong.system.common.utils.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Properties配置文件解析器
 * @author Administrator
 */
public class PropertiesConfig {

	/**
	 * 日志
	 */
	private static final Log logger = LogFactory.getLog(PropertiesConfig.class);
	/**
	 * JDBC
	 */
	public static final String DEFAULT_CONFIG = "jdbc";
	/**
	 * 值为Properties的Map
	 */
	private Map<String, Properties> map;
	/**
	 * 单例模式
	 */
	private static PropertiesConfig propertiesConfig = new PropertiesConfig();

	public static PropertiesConfig getInstance() {
		return propertiesConfig;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private PropertiesConfig() {
		this.map = new HashMap();
		loadProperty("jdbc");
	}

	public Properties getProperties() {
		return getProperties("jdbc");
	}

	public Properties getProperties(String config) {
		Properties properties = (Properties) this.map.get(config);
		if (properties == null) {
			loadProperty(config);
			properties = (Properties) this.map.get(config);
		}
		return properties;
	}

	/**
	 * 加载读入Properties配置文件
	 * @param config
	 */
	private void loadProperty(String config) {
		Properties props = new Properties();
		try {
			props.load(PropertiesConfig.class.getResourceAsStream("/" + config
					+ ".properties"));
			this.map.put(config, props);
		} catch (IOException e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		}
	}

	public String getProperty(String config, String key) {
		return (String) getProperties(config).get(key);
	}

	public String getProperty(String key) {
		return (String) getProperties("jdbc").get(key);
	}
}
