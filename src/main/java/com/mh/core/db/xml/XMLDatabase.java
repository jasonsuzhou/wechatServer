package com.mh.core.db.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.springframework.core.io.ClassPathResource;

import com.mh.wechat.util.CaseInSensitiveHashMap;
import com.mh.wechat.util.XMLUtil;

public class XMLDatabase {

	private static final String CONFIG_FILE = "db.xml";
	private static final String NODE_TABLE = "table";
	private static final String NODE_ROW = "row";
	private static final String ATTR_NAME = "name";
	private static final String ATTR_PRIMAKRY_KEY = "primary-key";
	private static boolean isInit = false;

	private static Map<String, Object> hmTable = new CaseInSensitiveHashMap();

	public static Map<String, Object> getHmTable() {
		loadDatabase();
		return hmTable;
	}

	public static XMLTable getTable(String tableName) {
		return (XMLTable) getHmTable().get(tableName);
	}

	private static void loadDatabase() {
		try {
			if (!isInit) {
				File file = new ClassPathResource(CONFIG_FILE).getFile();
				Document doc = XMLUtil.xmlFileToDom(file);
				Element eleRoot = doc.getRootElement();
				List<Element> lsEleTable = XMLUtil.findChildNodes(NODE_TABLE, eleRoot);
				loadTables(lsEleTable);
				isInit = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void loadTables(List<Element> lsEleTable) {
		XMLTable table = null;
		String tableName = "";
		String primaryKey = "";
		for (Element eleTable : lsEleTable) {
			table = new XMLTable();
			tableName = XMLUtil.getNodeAttribute(eleTable, ATTR_NAME);
			primaryKey = XMLUtil.getNodeAttribute(eleTable, ATTR_PRIMAKRY_KEY);
			table.setName(tableName);
			table.setPrimaryKey(primaryKey.toUpperCase());
			table.setLsRows(loadRows(XMLUtil.findChildNodes(NODE_ROW, eleTable), table));
			hmTable.put(tableName, table);
		}
	}

	private static List<Map<String, Object>> loadRows(List<Element> lsEleRow, XMLTable table) {
		List<Map<String, Object>> lsRow = new ArrayList<Map<String, Object>>();
		int index = 0;
		for (Element eleRow : lsEleRow) {
			List<Element> lsElement = eleRow.elements();
			lsRow.add(loadRecord(lsElement, table, index));
			index++;
		}
		return lsRow;
	}

	private static Map<String, Object> loadRecord(List<Element> lsElement, XMLTable table, int index) {
		String primaryKey = table.getPrimaryKey();
		Map<String, Object> map = new CaseInSensitiveHashMap();
		String nodeName = "";
		String nodeValue = "";
		for (Element eleName : lsElement) {
			if (eleName.getNodeType() == Element.ELEMENT_NODE) {
				nodeName = eleName.getName();
				nodeValue = XMLUtil.getNodeValue(eleName, true);
				if (nodeName.equalsIgnoreCase(primaryKey)) {
					table.putIndex(nodeValue, index);
				}
				map.put(nodeName, nodeValue);
			}
		}
		return map;
	}

}
