package com.mh.wechat.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mh.wechat.dao.DAOFactory;
import com.mh.wechat.dao.UserDAO;
import com.mh.wechat.web.util.SessionManager;

@Controller
public class UserController {

	private UserDAO userDAO = DAOFactory.getUserDAO();

	@RequestMapping("/adminlogin")
	public @ResponseBody
	Object adminLogin(HttpServletRequest request, String username, String password) {
		Map<String, String> map = new HashMap<String, String>();
		if (this.userDAO.canLogin(username, password)) {
			request.getSession().invalidate();
			SessionManager.putAdminUserName(request, username);
			map.put("result", "success");
		} else {
			map.put("result", "failed");
		}
		return map;
	}

	@RequestMapping("/admin/home")
	public String gotoHomePage() {
		return "home";
	}

	@RequestMapping("/logout")
	public String gotoLoginPage(HttpServletRequest request) {
		request.getSession().invalidate();
		return "../../login";
	}
	
}
