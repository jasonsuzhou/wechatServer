package com.mh.wechat.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mh.wechat.entity.Menu;
import com.mh.wechat.entity.MenuButton;
import com.mh.wechat.entity.WeChatResponse;
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

	@RequestMapping("/showLocalMenuDetail")
	public ModelAndView showLocalMenuDetail(HttpServletRequest request) throws Exception {
		String key = request.getParameter("key");
		MenuButton menuButton = MenuConfig.getMenuByKey(key);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", menuButton);
		return new ModelAndView("menu/detail", map);
	}

	@RequestMapping("/deleteAllServerMenu")
	public @ResponseBody
	Object deleteAllServerMenu() throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		String result = menuService.deleteAllMenu();
		WeChatResponse response = new WeChatResponse().parseJson(result);
		if ("0".equals(response.getErrcode()) && "ok".equals(response.getErrmsg())) {
			map.put("result", "success");
		} else {
			map.put("result", "error");
		}
		return map;
	}

	@RequestMapping("/addAllServerMenu")
	public @ResponseBody
	Object addAllServerMenu() {
		Map<String, String> map = new HashMap<String, String>();
		WeChatResponse response = menuService.createMenu();
		if ("0".equals(response.getErrcode()) && "ok".equals(response.getErrmsg())) {
			map.put("result", "success");
		} else {
			map.put("result", "error");
		}
		return map;
	}

}
