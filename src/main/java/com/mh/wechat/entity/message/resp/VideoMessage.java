package com.mh.wechat.entity.message.resp;

import com.mh.wechat.constants.Const;

public class VideoMessage extends ResponseMessage {

	private Video Video;

	public Video getVideo() {
		return Video;
	}

	public void setVideo(Video video) {
		Video = video;
	}

	@Override
	public String getMsgType() {
		return Const.MessageType.VIDEO;
	}

}
