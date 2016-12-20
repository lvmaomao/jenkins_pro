package com.kuangwen.jenkins.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	public static final String TOKEN = "token";
	public static final String DOWN_LOAD_PATH = "down_load_path";
	private static Properties properties;
	static {
		try {
			InputStream in = NetUtil.class.getClassLoader().getResourceAsStream("local.properties");
		    properties = new Properties();
			properties.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getValue(String key) {
		return properties.getProperty(key);
	}

}
