package com.mh.wechat.dao.impl;

import java.util.Map;

import com.mh.core.db.xml.XMLDatabase;
import com.mh.core.db.xml.XMLTable;
import com.mh.wechat.dao.UserDAO;
import com.mh.wechat.util.WeChatUtil;

public class XMLUserDAOImpl implements UserDAO {

	private static XMLUserDAOImpl instance = new XMLUserDAOImpl();

	public static UserDAO getInstance() {
		return instance;
	}

	@Override
	public boolean canLogin(String username, String password) {
		XMLTable userTable = XMLDatabase.getTable("user");
		Map<String, Object> hmRow = userTable.getSingleRecord(username);
		if (hmRow == null) {
			return false;
		} else {
			String dbusername = (String) hmRow.get("username");
			String dbpassword = (String) hmRow.get("password");
			String passwordSummary = WeChatUtil.genSHA1Summary(password);
			if (dbusername.equals(username) && dbpassword.equals(passwordSummary)) {
				return true;
			}
		}
		return false;
	}

}
