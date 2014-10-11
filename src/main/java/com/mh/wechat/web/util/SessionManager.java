package com.mh.wechat.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionManager {

	private static final String SES_USER_NAME = "sessionAdminUserName";

	public static String getAdminUserName(HttpServletRequest request) {
		HttpSession session = getHttpSession(request);
		return (String) session.getAttribute(SES_USER_NAME);
	}

	public static void putAdminUserName(HttpServletRequest request, String username) {
		HttpSession session = getHttpSession(request);
		session.setAttribute(SES_USER_NAME, username);
	}

	public static HttpSession getHttpSession(HttpServletRequest request) {
		return request.getSession();
	}

}
