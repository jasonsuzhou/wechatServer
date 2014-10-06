package com.mh.wechat.entity;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MenuTest {
	
	@Test
	public void testGenCreateJson() throws Exception {
		Menu menu = new Menu();
		menu.setButton(this.prepareMenuButton());
		System.out.println(menu.genJsonMenu());
	}
	
	
	private List<MenuButton> prepareMenuButton() {
		List<MenuButton> lsButton = new ArrayList<MenuButton>();
		List<MenuButton> lsSubButton1 = new ArrayList<MenuButton>();
		MenuButton button1 = new MenuButton();
		button1.setName("生活助手");
		
		MenuButton subbutton1 = new MenuButton();
		subbutton1.setKey("11");
		subbutton1.setName("天气预报");
		subbutton1.setType("click");
		subbutton1.setUrl("http://weather1.sina.cn/?vt=4");
		
		MenuButton subbutton2 = new MenuButton();
		subbutton2.setKey("12");
		subbutton2.setName("车型库");
		subbutton2.setType("click");
		subbutton2.setUrl("http://data.auto.sina.cn/?vt=4");
		
		lsSubButton1.add(subbutton1);
		lsSubButton1.add(subbutton2);
		button1.setSub_button(lsSubButton1);
		
		lsButton.add(button1);
		return lsButton;
	}

}
