package com.mh.wechat.service;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

import com.mh.wechat.constants.Const;
import com.mh.wechat.entity.message.req.EventMessage;
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
		// the process result will be a xml format string
		String processResult = "";
		String messageType = XMLUtil.getChildNodeValue(eRoot, RequestMessageUtil.NODE_MSG_TYPE, true);
		if (Const.MessageType.TEXT.equals(messageType)) {
			TextMessage requestMessage = RequestMessageUtil.genTextMessage(eRoot);
			String content = requestMessage.getContent();
			if ("1".equals(content)) {
				processResult = this.genRespSingleNewsMessage(requestMessage);
			} else if ("2".equals(content)) {
				processResult = this.genRespMultiNewsMessage(requestMessage);
			} else {
				processResult = genRespTextMessage(requestMessage);
			}
		} else if (Const.MessageType.EVENT.equals(messageType)) {
			EventMessage requestMessage = RequestMessageUtil.genEventMessage(eRoot);
			String fromUser = requestMessage.getToUserName();
			String toUser = requestMessage.getFromUserName();
			String eventType = requestMessage.getEvent();
			// when the followed you, he/she will received this message
			if (eventType.equals(Const.EventType.SUBSCRIBE)) {
				String content = "欢迎加我为关注，新功能会持续更新...";
				processResult = genRespTextMessage(content, fromUser, toUser);
			} else if (eventType.equals(Const.EventType.UNSUBSCRIBE)) {
				// user unfollowed, can log here
			} else if (eventType.equals(Const.EventType.CLICK)) {
				// sub menu click
				String eventKey = requestMessage.getEventKey();
				if (Const.EventKey.ABOUT_ME.equals(eventKey)) {
					String content = "姚敏华，男，一个80后程序员！10年入行，从业已四年有余，主要从事银行方面的系统开发.";
					processResult = genRespTextMessage(content, fromUser, toUser);
				} else if(Const.EventKey.CONTACT_ME.equals(eventKey)) {
					StringBuilder sb = new StringBuilder();
					sb.append("Email:jason.yao525@gmail.com").append("\r\n");
					sb.append("Blog:http://121.42.11.139/blog").append("\r\n");
					sb.append("GitHub:https://github.com/jasonsuzhou").append("\r\n");
					processResult = genRespTextMessage(sb.toString(), fromUser, toUser);
				} else if(Const.EventKey.SKILL_SETS.equals(eventKey)){
					String  content = ""; 
					content += "1. Solid basic of JAVA/Javascript/Shell.\r\n";
					content += "2. Proficiency in SpringMVC/Spring/Hibernate/Struts2/WebService/Jasper/Junit/Mockito/JMS etc.\r\n";
					content += "3. Proficiency in JQuery/JQuery Mobile/ExtJS.\r\n";
					content += "4. Proficiency in MySQL/Oracle.\r\n";
					content += "5. Excellent in IBM WebShphere Application Server/Tomcat/IBM WebSphere MQ etc.\r\n";
					content += "6. Excellent in Eclipse/MyEclipse/Rational Application Developer/iTerm.\r\n";
					content += "7. Excellent in Git/Jenkins/SVN/CVS.\r\n";
					content += "8. Excellent in Ubuntu/Mac OSX/AIX.\r\n";
					content += "9. Pass CET-6 Fluent in read/spoken/written.\r\n";
					content += "10 Have fan with WeChat Development";
					processResult = genRespTextMessage(content, fromUser, toUser);
				} else if(Const.EventKey.WORKS.equals(eventKey)) {
					String content = "";
					content += "Blog(My personal blog with SpringMVC Restful):http://121.42.11.139/blog\r\n";
					content += "WechatServer(My wechat official account backend with JQuery Mobile):http://121.42.11.139/wechatServer\r\n";
					content += "PMS(Manage the pictures with SSH):http://121.42.11.139/PMS\r\n";
					content += "Jenkins(CI tools to build my projects):http://121.42.11.139/jenkins\r\n";
					processResult = genRespTextMessage(content, fromUser, toUser);
				} else if (Const.EventKey.SINGLE_IMAGE_ARTICLE_DEMO.equals(eventKey)) {
					processResult = this.genRespSingleNewsMessage(fromUser, toUser);
				} else if (Const.EventKey.MULTI_IMAGE_ARTICLE_DEMO.equals(eventKey)) {
					processResult = genRespMultiNewsMessage(fromUser, toUser);
				}
			}
		} else {
			// TODO
		}
		return processResult;
	}

	private String genRespMultiNewsMessage(String fromUser, String toUser) {
		NewsMessage responseMessage = new NewsMessage();
		responseMessage.setFromUserName(fromUser);
		responseMessage.setToUserName(toUser);
		responseMessage.setArticles(getMultiListArticles());
		return ResponseMessageUtil.genNewsMessage(responseMessage);
	}

	private String genRespSingleNewsMessage(String fromUser, String toUser) {
		NewsMessage responseMessage = new NewsMessage();
		responseMessage.setFromUserName(fromUser);
		responseMessage.setToUserName(toUser);
		responseMessage.setArticles(getListArticles());
		return ResponseMessageUtil.genNewsMessage(responseMessage);
	}

	private String genRespTextMessage(TextMessage requestMessage) {
		RespTextMessage responseMessage = new RespTextMessage();
		responseMessage.setContent("This is a auto reply message, 本屌正在开发此公众平台。。。");
		responseMessage.setFromUserName(requestMessage.getToUserName());
		responseMessage.setFuncFlag(0);
		responseMessage.setToUserName(requestMessage.getFromUserName());
		return ResponseMessageUtil.genTextMessage(responseMessage);
	}

	private String genRespTextMessage(String content, String fromUser, String toUser) {
		RespTextMessage responseMessage = new RespTextMessage();
		responseMessage.setContent(content);
		responseMessage.setFromUserName(fromUser);
		responseMessage.setFuncFlag(0);
		responseMessage.setToUserName(toUser);
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
