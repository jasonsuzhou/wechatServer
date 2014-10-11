package com.mh.core.db.xml;

import java.util.List;
import java.util.Map;

import com.mh.wechat.util.CaseInSensitiveHashMap;

public class XMLTable {

	private String name;
	private String primaryKey;
	private List<Map<String, Object>> lsRows;
	private Map<String, Object> hmIndex = new CaseInSensitiveHashMap();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Map<String, Object>> getLsRows() {
		return lsRows;
	}

	public void setLsRows(List<Map<String, Object>> lsRows) {
		this.lsRows = lsRows;
	}

	public String getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	public Map<String, Object> getHmIndex() {
		return hmIndex;
	}

	public void setHmIndex(Map<String, Object> hmIndex) {
		this.hmIndex = hmIndex;
	}

	public void putIndex(String key, Integer index) {
		this.hmIndex.put(key, index);
	}

	public Map<String, Object> getSingleRecord(String primaryKey) {
		Object oIndex = this.hmIndex.get(primaryKey);
		if (null != oIndex) {
			int index = Integer.parseInt(oIndex.toString());
			return this.lsRows.get(index);
		} else {
			return null;
		}
	}

}
