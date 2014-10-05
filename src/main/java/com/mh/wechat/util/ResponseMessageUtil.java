package com.mh.wechat.util;

import java.util.Date;

import org.dom4j.Document;
import org.dom4j.Element;

import com.mh.wechat.entity.message.resp.RespTextMessage;

public class ResponseMessageUtil {
	private static final String NODE_ROOT = "xml";
	private static final String NODE_TO_USER_NAME = "ToUserName";
	private static final String NODE_FROM_USER_NAME = "FromUserName";
	private static final String NODE_CREATED_TIME = "CreateTime";
	private static final String NODE_MSG_TYPE = "MsgType";
	private static final String NODE_CONTENT = "Content";

	public static String genTextMessage(RespTextMessage message) {
		Document document = XMLUtil.createDocument(NODE_ROOT);
		Element eRoot = document.getRootElement();
		XMLUtil.populateCDATAElement(eRoot, NODE_TO_USER_NAME, message.getToUserName());
		XMLUtil.populateCDATAElement(eRoot, NODE_FROM_USER_NAME, message.getFromUserName());
		XMLUtil.populateElement(eRoot, NODE_CREATED_TIME, String.valueOf(new Date().getTime()), false);
		XMLUtil.populateCDATAElement(eRoot, NODE_MSG_TYPE, message.getMsgType());
		XMLUtil.populateCDATAElement(eRoot, NODE_CONTENT, message.getContent());
		return document.asXML();
	}
	
}
