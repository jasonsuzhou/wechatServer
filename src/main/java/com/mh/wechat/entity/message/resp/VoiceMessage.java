package com.mh.wechat.entity.message.resp;

import com.mh.wechat.constants.Const;

public class VoiceMessage extends ResponseMessage {
	
	/**
	 * by upload the voice will get this id
	 */
	private String MediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	@Override
	public String getMsgType() {
		return Const.MessageType.VOICE;
	}

	
}
