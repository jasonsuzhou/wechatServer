package com.mh.wechat.entity.message.resp;

import com.mh.wechat.constants.Const;

public class RespTextMessage extends ResponseMessage {

	/**
	 * The reply message content
	 */
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	@Override
	public String getMsgType() {
		return Const.MessageType.TEXT;
	}
}
