package com.mh.wechat.service;

import org.dom4j.Element;

import com.mh.wechat.constants.Const;
import com.mh.wechat.entity.message.req.TextMessage;
import com.mh.wechat.entity.message.resp.RespTextMessage;
import com.mh.wechat.util.RequestMessageUtil;
import com.mh.wechat.util.ResponseMessageUtil;
import com.mh.wechat.util.XMLUtil;

public class WeChatServiceImpl {
	
	private static WeChatServiceImpl weChatService = new WeChatServiceImpl();
	
	public static WeChatServiceImpl getInstance() {
		return weChatService;
	}

	public String processRequest(Element eRoot) {
		String processResult = "";
		String messageType = XMLUtil.getChildNodeValue(eRoot, RequestMessageUtil.NODE_MSG_TYPE, true);
		if(Const.MessageType.TEXT.equals(messageType)) {
			TextMessage requestMessage = RequestMessageUtil.genTextMessage(eRoot);
			RespTextMessage responseMessage = new RespTextMessage();
			responseMessage.setContent("This is a auto reply message, 本屌正在开发此公众平台。。。");
			responseMessage.setFromUserName(requestMessage.getToUserName());
			responseMessage.setFuncFlag(0);
			responseMessage.setToUserName(requestMessage.getFromUserName());
			processResult = ResponseMessageUtil.genTextMessage(responseMessage);
		}
		return processResult;
	}

}
