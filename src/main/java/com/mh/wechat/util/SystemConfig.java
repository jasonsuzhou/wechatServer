package com.mh.wechat.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;

import com.mh.wechat.constants.ConstSystemConfig;

public class SystemConfig {

	private static Map<String, String> hmConfig = new HashMap<String, String>();
	private static boolean isInit = false;
	
	public static String getDataStoreType() {
		return getHmConfig().get(ConstSystemConfig.DATA_STORE_TYPE);
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
				hmConfig.put(ConstSystemConfig.DATA_STORE_TYPE, (String) props.get(ConstSystemConfig.DATA_STORE_TYPE));
				isInit = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
