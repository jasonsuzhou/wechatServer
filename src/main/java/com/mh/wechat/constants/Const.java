package com.mh.wechat.constants;

public class Const {

	public static final String MY_WECHAT_TOKEN = "jasonyao";

	/**
	 * The message type of the wechat
	 * @author jasonyao
	 *
	 */
	public interface MessageType {
		public static final String TEXT = "text";
		public static final String IMAGE = "image";
		public static final String VOICE = "voice";
		public static final String VIDEO = "video";
		public static final String LOCATION = "location";
		public static final String LINK = "link";
		
		public static final String RESP_NEWS = "news";
		public static final String RESP_MUSIC = "music";
	}

}
