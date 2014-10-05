package com.mh.wechat.entity.message.resp;

import java.util.List;

import com.mh.wechat.constants.Const;

/**
 * The response contains both content and images if only need single
 * image&article, just keep one article
 * 
 * @author jasonyao
 * 
 */
public class NewsMessage extends ResponseMessage {

	/**
	 * the counts of the image&article, limit 0-10.
	 */
	private int ArticleCount;

	/**
	 * list of image*article
	 */
	private List<Article> Articles;

	public int getArticleCount() {
		return ArticleCount;
	}

	public List<Article> getArticles() {
		return Articles;
	}

	public void setArticles(List<Article> articles) {
		Articles = articles;
	}

	@Override
	public String getMsgType() {
		return Const.MessageType.RESP_NEWS;
	}

}
