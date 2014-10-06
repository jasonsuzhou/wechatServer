package com.mh.wechat.constants;

public class Const {

	public static final String MY_WECHAT_TOKEN = "jasonyao";
	public static final String APP_ID = "wx11a1ad9eb6a1a5b3";
	public static final String APP_SECRET = "ce5db7a73132c64010a2aeec57e24549";
	public static final String ACCESS_TOKEN = "ACCESS_TOKEN";

	/**
	 * The message type of the wechat
	 * 
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
		public static final String EVENT = "event";

		public static final String RESP_NEWS = "news";
		public static final String RESP_MUSIC = "music";
	}

	public interface EventType {
		/**
		 * When click the menu
		 */
		public static final String CLICK = "CLICK";
		/**
		 * When user follow the official account
		 */
		public static final String SUBSCRIBE = "subscribe";
		/**
		 * When user unfollow the official account
		 */
		public static final String UNSUBSCRIBE = "unsubscribe";
	}

	public interface RequestMethod {
		public static final String GET = "GET";
		public static final String POST = "POST";
	}

	public interface WeChatMenuAPI {
		public static final String CREATE_MENU = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
		public static final String GET_MENU = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
		public static final String DELETE_MENU = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	}

}
