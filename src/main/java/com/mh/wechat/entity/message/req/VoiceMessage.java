package com.mh.wechat.entity.message.req;

public class VoiceMessage extends RequestMessage {

	/**
	 * The media id which can use this to get data from download API
	 */
	private String MediaId;

	/**
	 * The format type of the voice, e.g. amr,speex.
	 */
	private String Format;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

}
