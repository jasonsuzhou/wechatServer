package com.mh.wechat.web.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.springframework.core.io.ClassPathResource;

import com.mh.wechat.entity.Menu;
import com.mh.wechat.entity.MenuButton;
import com.mh.wechat.util.XMLUtil;

public class MenuConfig {

	private static Menu menu;
	private static boolean isInit = false;

	public static void initConfig() throws Exception {
		if (!isInit) {
			List<MenuButton> lsMenuButton = new ArrayList<MenuButton>();
			File file = new ClassPathResource("menuConfig.xml").getFile();
			Document document = XMLUtil.xmlFileToDom(file);
			Element eRoot = document.getRootElement();
			List<Element> lsButton = XMLUtil.findChildNodes("button", eRoot);
			menu = new Menu();
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
		}
		isInit = true;
	}

	private static List<MenuButton> getSubButtonFromConfig(Element eleButton) {
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

	public static Menu getMenu() {
		return menu;
	}

	public static MenuButton getMenuByKey(String key) {
		List<MenuButton> list = getMenu().getButton();
		for (MenuButton button : list) {
			if (key.equals(button.getKey())) {
				return button;
			} else {
				List<MenuButton> sublist = button.getSub_button();
				for (MenuButton subbutton : sublist) {
					if (key.equals(subbutton.getKey())) {
						return subbutton;
					}
				}
			}
		}
		return null;
	}

}
