package com.mh.wechat.entity.message.resp;

import com.mh.wechat.constants.Const;

public class ImageMessage extends ResponseMessage {

	/**
	 * By upload the image will get this id
	 */
	private String MediaId;

	@Override
	public String getMsgType() {
		return Const.MessageType.IMAGE;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

}
