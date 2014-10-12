package com.mh.wechat.dao;

import com.mh.wechat.dao.impl.XMLUserDAOImpl;
import com.mh.wechat.web.util.SystemConfig;

public class DAOFactory {

	public static UserDAO getUserDAO() {
		String dataStoreType = SystemConfig.getDataStoreType();
		if ("xml".equalsIgnoreCase(dataStoreType)) {
			return XMLUserDAOImpl.getInstance();
		}
		if ("database".equalsIgnoreCase(dataStoreType)) {
			return null;
		}
		return null;
	}

}
