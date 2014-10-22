package com.mh.wechat.entity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Menu {

	private List<MenuButton> button;

	public List<MenuButton> getButton() {
		return button;
	}

	public void setButton(List<MenuButton> button) {
		this.button = button;
	}

	public String genJsonMenu() throws JsonProcessingException, IOException {
		ObjectMapper objMapper = new ObjectMapper();
		String result = objMapper.writeValueAsString(this);
		//String result = null;
		//OutputStream os = new ByteArrayOutputStream();
		//JsonGenerator generator = new ObjectMapper().getJsonFactory().createJsonGenerator(os, JsonEncoding.UTF8);
		//generator.writeObject(this);
		//result = os.toString();
		//if (generator != null) {
		//	generator.close();
		//}
		//if (os != null) {
		//	os.close();
		//}
		return result;
	}

}
