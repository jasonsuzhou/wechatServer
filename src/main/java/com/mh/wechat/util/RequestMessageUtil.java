package com.mh.wechat.util;

import org.dom4j.Element;

import com.mh.wechat.entity.message.req.TextMessage;

public class RequestMessageUtil {

	public static final String NODE_TO_USER_NAME = "ToUserName";
	public static final String NODE_FROM_USER_NAME = "FromUserName";
	public static final String NODE_CREATED_TIME = "CreateTime";
	public static final String NODE_MSG_TYPE = "MsgType";
	public static final String NODE_CONTENT = "Content";
	public static final String NODE_MSG_ID = "MsgId";

	public static TextMessage genTextMessage(Element eRoot) {
		TextMessage message = new TextMessage();
		message.setContent(XMLUtil.getChildNodeValue(eRoot, NODE_CONTENT, true));
		message.setCreateTime(Long.valueOf(XMLUtil.getChildNodeValue(eRoot, NODE_CREATED_TIME, true)));
		message.setFromUserName(XMLUtil.getChildNodeValue(eRoot, NODE_FROM_USER_NAME, true));
		message.setMsgId(Long.valueOf(XMLUtil.getChildNodeValue(eRoot, NODE_MSG_ID, true)));
		message.setMsgType(XMLUtil.getChildNodeValue(eRoot, NODE_MSG_TYPE, true));
		message.setToUserName(XMLUtil.getChildNodeValue(eRoot, NODE_TO_USER_NAME, true));
		return message;
	}

}
