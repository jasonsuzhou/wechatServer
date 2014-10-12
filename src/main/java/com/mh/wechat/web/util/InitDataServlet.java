package com.mh.wechat.web.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitDataServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		try {
			SystemConfig.initConfig();
			MenuConfig.initConfig();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
