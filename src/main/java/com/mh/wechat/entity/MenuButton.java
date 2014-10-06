package com.mh.wechat.entity;

import java.util.ArrayList;
import java.util.List;

public class MenuButton {

	private String name;
	private String key;
	private String type;
	private String url;
	private List<MenuButton> sub_button = new ArrayList<MenuButton>();

	public String getName() {
		return name == null ? "" : name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key == null ? "" : key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getType() {
		return type == null ? "" : type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url == null ? "" : url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<MenuButton> getSub_button() {
		return sub_button;
	}

	public void setSub_button(List<MenuButton> sub_button) {
		this.sub_button = sub_button;
	}

}
