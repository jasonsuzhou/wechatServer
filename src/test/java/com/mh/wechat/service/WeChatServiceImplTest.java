package com.mh.wechat.service;

import org.junit.Test;

import com.mh.wechat.constants.Const;
import com.mh.wechat.entity.message.req.TextMessage;

public class WeChatServiceImplTest {
	
	
	@Test
	public void testGenNewsMessage() {
		WeChatServiceImpl wechat = WeChatServiceImpl.getInstance();
		TextMessage message = new TextMessage();
		message.setContent("1");
		message.setMsgId(123);
		message.setMsgType(Const.MessageType.TEXT);
		message.setFromUserName("jason");
		message.setToUserName("salk");
		String result = wechat.genRespSingleNewsMessage(message);
		System.out.println(result);
	}

}
