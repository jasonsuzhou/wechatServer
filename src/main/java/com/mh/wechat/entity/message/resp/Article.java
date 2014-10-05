package com.mh.wechat.entity.message.resp;

public class Article {

	/**
	 * The name of the article
	 */
	private String Title;

	/**
	 * The description of the article
	 */
	private String Description;

	/**
	 * The image URL. only support JPG,PNG format.</br> big size shall be
	 * 360*200, small size shall be 200*200
	 */
	private String PicUrl;

	/**
	 * The forward link when click the article.
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

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

}
