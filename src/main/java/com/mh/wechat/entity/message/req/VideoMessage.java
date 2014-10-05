package com.mh.wechat.entity.message.req;

public class VideoMessage extends RequestMessage {
	/**
	 * The media id which can use this to get data from download API
	 */
	private String MediaId;

	/**
	 * The summary image of the video, can use this to get data from download
	 * API
	 */
	private String ThumbMediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

}
