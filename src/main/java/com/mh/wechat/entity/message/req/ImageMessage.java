package com.mh.wechat.entity.message.req;

public class ImageMessage extends RequestMessage {

	/**
	 * The URL of the image
	 */
	private String PicUrl;

	/**
	 * The media id which can use this to get data from download API
	 */
	private String MediaId;

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

}
