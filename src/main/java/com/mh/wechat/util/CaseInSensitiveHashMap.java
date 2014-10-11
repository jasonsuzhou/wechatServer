package com.mh.wechat.util;

import java.util.LinkedHashMap;

public class CaseInSensitiveHashMap extends LinkedHashMap<String, Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2744848615982616357L;

	@Override
	public Object get(Object key) {
		if (key == null) {
			return null;
		}
		return super.get(key.toString().toUpperCase());
	}

	@Override
	public Object put(String key, Object value) {
		return super.put(key.toUpperCase(), value);
	}

}
