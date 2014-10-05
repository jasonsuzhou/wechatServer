package com.mh.wechat.util;

import java.util.Date;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.mh.wechat.entity.message.resp.Article;
import com.mh.wechat.entity.message.resp.NewsMessage;
import com.mh.wechat.entity.message.resp.RespTextMessage;

public class ResponseMessageUtil {
	private static final String NODE_ROOT = "xml";
	private static final String NODE_TO_USER_NAME = "ToUserName";
	private static final String NODE_FROM_USER_NAME = "FromUserName";
	private static final String NODE_CREATED_TIME = "CreateTime";
	private static final String NODE_MSG_TYPE = "MsgType";
	private static final String NODE_CONTENT = "Content";
	private static final String NODE_ARTICLE_COUNT = "ArticleCount";
	private static final String NODE_ARTICLES = "Articles";
	private static final String NODE_ITEM = "item";
	private static final String NODE_TITLE = "Title";
	private static final String NODE_DESCRIPTION = "Description";
	private static final String NODE_PIC_URL = "PicUrl";
	private static final String NODE_URL = "Url";

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

	public static String genNewsMessage(NewsMessage message) {
		Document document = XMLUtil.createDocument(NODE_ROOT);
		Element eRoot = document.getRootElement();
		XMLUtil.populateCDATAElement(eRoot, NODE_TO_USER_NAME, message.getToUserName());
		XMLUtil.populateCDATAElement(eRoot, NODE_FROM_USER_NAME, message.getFromUserName());
		XMLUtil.populateElement(eRoot, NODE_CREATED_TIME, String.valueOf(new Date().getTime()), false);
		XMLUtil.populateCDATAElement(eRoot, NODE_MSG_TYPE, message.getMsgType());
		List<Article> lsArticle = message.getArticles();
		int size = lsArticle.size();
		XMLUtil.populateTextElement(eRoot, NODE_ARTICLE_COUNT, String.valueOf(size));
		eRoot.add(genArticlesElement(lsArticle));
		return document.asXML();
	}

	private static Element genArticlesElement(List<Article> lsArticle) {
		Element articles = DocumentHelper.createElement(NODE_ARTICLES);
		appendArticleItems(articles, lsArticle);
		return articles;
	}

	private static void appendArticleItems(Element articles, List<Article> lsArticle) {
		for (Article article : lsArticle) {
			Element item = DocumentHelper.createElement(NODE_ITEM);
			XMLUtil.populateCDATAElement(item, NODE_TITLE, article.getTitle());
			XMLUtil.populateCDATAElement(item, NODE_DESCRIPTION, article.getDescription());
			XMLUtil.populateCDATAElement(item, NODE_PIC_URL, article.getPicUrl());
			XMLUtil.populateCDATAElement(item, NODE_URL, article.getTitle());
			articles.add(item);
		}
	}
}
