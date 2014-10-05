package com.mh.wechat.entity.message.req;


public class TextMessage extends RequestMessage {

	/**
	 * The message content
	 */
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

}
