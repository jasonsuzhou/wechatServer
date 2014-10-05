package com.mh.wechat.service;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

import com.mh.wechat.constants.Const;
import com.mh.wechat.entity.message.req.TextMessage;
import com.mh.wechat.entity.message.resp.Article;
import com.mh.wechat.entity.message.resp.NewsMessage;
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
			String content = requestMessage.getContent();
			if("1".equals(content)) {
				processResult = this.genRespSingleNewsMessage(requestMessage);
			} else {
				processResult = genRespTextMessage(requestMessage);
			}
		} else {
			//TODO
		}
		return processResult;
	}

	private String genRespTextMessage(TextMessage requestMessage) {
		RespTextMessage responseMessage = new RespTextMessage();
		responseMessage.setContent("This is a auto reply message, 本屌正在开发此公众平台。。。");
		responseMessage.setFromUserName(requestMessage.getToUserName());
		responseMessage.setFuncFlag(0);
		responseMessage.setToUserName(requestMessage.getFromUserName());
		return ResponseMessageUtil.genTextMessage(responseMessage);
	}
	
	public String genRespSingleNewsMessage(TextMessage requestMessage) {
		NewsMessage responseMessage = new NewsMessage();
		responseMessage.setFromUserName(requestMessage.getToUserName());
		responseMessage.setToUserName(requestMessage.getFromUserName());
		responseMessage.setArticles(getListArticles());
		return ResponseMessageUtil.genNewsMessage(responseMessage);
	}
	
	private List<Article> getListArticles() {
		List<Article> lsArticles = new ArrayList<Article>();
		Article article = new Article();
		article.setUrl("http://121.42.11.139/blog/gotoBlogDetail.do?id=13");
		article.setPicUrl("http://121.42.11.139/blog/images/icon/blog_java_icon.png");
		article.setTitle("若干个学生围成一个圈开始从1数数，3的倍数踢出圈，问最后一个是第几个学生，用OOP思想实现");
		article.setDescription("若干个学生围成一个圈开始从1数数，3的倍数踢出圈，问最后一个是第几个学生，用OOP思想实现");
		lsArticles.add(article);
		return lsArticles;
	}

}
