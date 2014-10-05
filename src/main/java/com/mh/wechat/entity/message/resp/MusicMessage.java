package com.mh.wechat.entity.message.resp;

import com.mh.wechat.constants.Const;

public class MusicMessage extends ResponseMessage {

	private Music Music;

	@Override
	public String getMsgType() {
		return Const.MessageType.RESP_MUSIC;
	}

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}

}
