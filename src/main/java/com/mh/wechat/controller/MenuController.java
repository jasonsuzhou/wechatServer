package com.mh.wechat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mh.wechat.entity.Menu;
import com.mh.wechat.service.MenuServiceImpl;
import com.mh.wechat.web.util.MenuConfig;

@Controller
@RequestMapping("/admin")
public class MenuController {

	private MenuServiceImpl menuService = new MenuServiceImpl();

	@RequestMapping("/localMenuList")
	public @ResponseBody
	Object queryLocalMenuList() {
		Menu menu = MenuConfig.getMenu();
		return menu.getButton();
	}

	@RequestMapping("/serverMenuList")
	public @ResponseBody
	Object queryServerMenuList() {
		String result = menuService.getMenu();
		System.out.println(result);
		return result;
	}

}
