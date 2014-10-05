package com.mh.wechat.entity.message.resp;

public class Video {

	/**
	 * by upload video will get this id
	 */
	private String MediaId;

	/**
	 * The title of the video
	 */
	private String Title;

	/**
	 * The description of the video
	 */
	private String Description;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

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

}
