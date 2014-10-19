package com.mh.wechat.web.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.core.io.ClassPathResource;

import com.mh.wechat.constants.ConstSystemConfig;

public class SystemConfig {

	private static Map<String, String> hmConfig = new HashMap<String, String>();
	private static boolean isInit = false;

	public static String getDataStoreType() {
		return getHmConfig().get(ConstSystemConfig.DATA_STORE_TYPE);
	}

	public static String getAppId() {
		return getHmConfig().get(ConstSystemConfig.APP_ID);
	}

	public static String getAppSecret() {
		return getHmConfig().get(ConstSystemConfig.APP_SECRET);
	}

	public static String getWeChatToken() {
		return getHmConfig().get(ConstSystemConfig.WECHAT_TOKEN);
	}

	public static String getAccessTokenAPI() {
		return getHmConfig().get(ConstSystemConfig.GET_ACCESS_TOKEN_API);
	}

	public static String getCreateMenuAPI() {
		return getHmConfig().get(ConstSystemConfig.CREATE_MENU);
	}

	public static String getQueryMenuAPI() {
		return getHmConfig().get(ConstSystemConfig.QUERY_MENU);
	}

	public static String getDeleteMenuAPI() {
		return getHmConfig().get(ConstSystemConfig.DELETE_MENU);
	}

	public static Map<String, String> getHmConfig() {
		initConfig();
		return hmConfig;
	}

	public static void initConfig() {
		try {
			if (!isInit) {
				File file = new ClassPathResource("systemConfig.properties").getFile();
				InputStream inputStream = new FileInputStream(file);
				Properties props = new Properties();
				props.load(inputStream);
				Set setKey = props.keySet();
				Iterator<String> it = setKey.iterator();
				String key = "";
				while (it.hasNext()) {
					key = it.next();
					hmConfig.put(key, (String) props.getProperty(key));
				}
				isInit = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void resetConfig() {
		isInit = false;
		initConfig();
	}

}
