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
			} else if("2".equals(content)) {
				processResult = this.genRespMultiNewsMessage(requestMessage);
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
	
	private String genRespMultiNewsMessage(TextMessage requestMessage) {
		NewsMessage responseMessage = new NewsMessage();
		responseMessage.setFromUserName(requestMessage.getToUserName());
		responseMessage.setToUserName(requestMessage.getFromUserName());
		responseMessage.setArticles(getMultiListArticles());
		return ResponseMessageUtil.genNewsMessage(responseMessage);
	}
	
	public String genRespSingleNewsMessage(TextMessage requestMessage) {
		NewsMessage responseMessage = new NewsMessage();
		responseMessage.setFromUserName(requestMessage.getToUserName());
		responseMessage.setToUserName(requestMessage.getFromUserName());
		responseMessage.setArticles(getListArticles());
		return ResponseMessageUtil.genNewsMessage(responseMessage);
	}
	
	private List<Article> getMultiListArticles() {
		List<Article> lsArticles = new ArrayList<Article>();
		Article article = new Article();
		article.setUrl("http://121.42.11.139/blog/gotoBlogDetail.do?id=13");
		article.setPicUrl("http://121.42.11.139/blog/images/icon/blog_java_icon.png");
		article.setTitle("若干个学生围成一个圈开始从1数数，3的倍数踢出圈，问最后一个是第几个学生，用OOP思想实现");
		article.setDescription("若干个学生围成一个圈开始从1数数，3的倍数踢出圈，问最后一个是第几个学生，用OOP思想实现");
		lsArticles.add(article);
		
		Article article2 = new Article();
		article2.setUrl("http://121.42.11.139/blog/gotoBlogDetail.do?id=8");
		article2.setPicUrl("http://121.42.11.139/blog/images/icon/blog_maven_icon.png");
		article2.setTitle("Maven to implement junit test and integration test");
		article2.setDescription("Maven to implement junit test and integration test");
		lsArticles.add(article2);
		
		Article article3 = new Article();
		article3.setUrl("http://121.42.11.139/blog/gotoBlogDetail.do?id=9");
		article3.setPicUrl("http://121.42.11.139/blog/images/icon/blog_default_js_icon.png");
		article3.setTitle("java bean convert to JSON string and JSON string convert to java bean");
		article3.setDescription("java bean convert to JSON string and JSON string convert to java bean");
		lsArticles.add(article3);
		return lsArticles;
		
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
