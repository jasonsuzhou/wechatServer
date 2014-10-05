package com.mh.wechat.entity.message.req;

public class LinkMessage extends RequestMessage {

	/**
	 * The title of the message
	 */
	private String Title;

	/**
	 * The description of the message
	 */
	private String Description;

	/**
	 * The url of the message
	 */
	private String Url;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

}
