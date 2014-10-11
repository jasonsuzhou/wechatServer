package com.mh.wechat.dao;

public interface UserDAO {

	boolean canLogin(String username, String password);
	
}
