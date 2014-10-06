package com.mh.wechat.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.springframework.core.io.ClassPathResource;

import com.mh.wechat.constants.Const;
import com.mh.wechat.entity.Menu;
import com.mh.wechat.entity.MenuButton;
import com.mh.wechat.entity.WeChatResponse;
import com.mh.wechat.util.WeChatUtil;
import com.mh.wechat.util.XMLUtil;

public class MenuServiceImpl {

	/**
	 * call wechat API to create menu<br/>
	 * if success will return {"errcode":0,"errmsg":"ok"}<br/>
	 * else will return {"errcode":40018,"errmsg":"invalid button name size"}
	 */
	public void createMenu() {
		String token = WeChatUtil.getGlobalAccessToken();
		if (StringUtils.isNotBlank(token)) {
			String requestUrl = Const.WeChatMenuAPI.CREATE_MENU.replace(Const.ACCESS_TOKEN, token);
			String data = this.getCreateMenuJsonFromConfig();
			WeChatResponse response = WeChatUtil.sendHttpsRequest(requestUrl, Const.RequestMethod.POST, data);
			System.out.println("error code::" + response.getErrcode());
			System.out.println("error message::" + response.getErrmsg());
		}
	}

	/**
	 * It will return JSON format data string
	 * 
	 * @return
	 */
	public String getMenu() {
		String token = WeChatUtil.getGlobalAccessToken();
		String reuslt = "";
		if (StringUtils.isNotBlank(token)) {
			String requestUrl = Const.WeChatMenuAPI.GET_MENU.replace(Const.ACCESS_TOKEN, token);
			reuslt = WeChatUtil.httpsRequest(requestUrl, Const.RequestMethod.GET, null);
		}
		return reuslt;
	}

	/**
	 * if success then return JSON : {"errcode":0,"errmsg":"ok"}
	 * 
	 * @return
	 */
	public String deleteAllMenu() {
		String token = WeChatUtil.getGlobalAccessToken();
		String result = "";
		if (StringUtils.isNotBlank(token)) {
			String requestUrl = Const.WeChatMenuAPI.DELETE_MENU.replace(Const.ACCESS_TOKEN, token);
			result = WeChatUtil.httpsRequest(requestUrl, Const.RequestMethod.GET, null);
		}
		return result;
	}

	public String getCreateMenuJsonFromConfig() {
		List<MenuButton> lsMenuButton = new ArrayList<MenuButton>();
		try {
			File file = new ClassPathResource("menuConfig.xml").getFile();
			Document document = XMLUtil.xmlFileToDom(file);
			Element eRoot = document.getRootElement();
			List<Element> lsButton = XMLUtil.findChildNodes("button", eRoot);
			Menu menu = new Menu();
			MenuButton menuButton = null;
			for (Element eleButton : lsButton) {
				menuButton = new MenuButton();
				menuButton.setKey(XMLUtil.getChildNodeValue(eleButton, "key", true));
				menuButton.setName(XMLUtil.getChildNodeValue(eleButton, "name", true));
				menuButton.setType(XMLUtil.getChildNodeValue(eleButton, "type", true));
				menuButton.setUrl(XMLUtil.getChildNodeValue(eleButton, "url", true));
				Element eleSubButton = XMLUtil.findChildNode("sub_button", eleButton);
				menuButton.setSub_button(getSubButtonFromConfig(eleSubButton));
				lsMenuButton.add(menuButton);
			}
			menu.setButton(lsMenuButton);
			return menu.genJsonMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public List<MenuButton> getSubButtonFromConfig(Element eleButton) {
		List<MenuButton> lsButton = new ArrayList<MenuButton>();
		List<Element> lsSubButton = XMLUtil.findChildNodes("button", eleButton);
		if (lsSubButton != null && !lsSubButton.isEmpty()) {
			MenuButton menuButton = null;
			for (Element subButton : lsSubButton) {
				menuButton = new MenuButton();
				menuButton.setKey(XMLUtil.getChildNodeValue(subButton, "key", true));
				menuButton.setName(XMLUtil.getChildNodeValue(subButton, "name", true));
				menuButton.setType(XMLUtil.getChildNodeValue(subButton, "type", true));
				menuButton.setUrl(XMLUtil.getChildNodeValue(subButton, "url", true));
				lsButton.add(menuButton);
			}
		}
		return lsButton;
	}

	public static void main(String[] args) throws Exception {
		// System.out.println(new
		// MenuServiceImpl().getCreateMenuJsonFromConfig());
		new MenuServiceImpl().createMenu();
		System.out.println(new MenuServiceImpl().getMenu());
	}
}
