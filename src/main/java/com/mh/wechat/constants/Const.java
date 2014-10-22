package com.mh.wechat.constants;

public class Const {

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
		 * View the response URL
		 */
		public static final String VIEW = "VIEW";
		/**
		 * When user follow the official account
		 */
		public static final String SUBSCRIBE = "subscribe";
		/**
		 * When user unfollow the official account
		 */
		public static final String UNSUBSCRIBE = "unsubscribe";
	}

	public interface EventKey {
		public static final String ABOUT_ME = "21";
		public static final String CONTACT_ME = "22";
		public static final String SKILL_SETS = "23";
		public static final String WORKS = "24";
		public static final String SINGLE_IMAGE_ARTICLE_DEMO = "31";
		public static final String MULTI_IMAGE_ARTICLE_DEMO = "32";
	}

	public interface RequestMethod {
		public static final String GET = "GET";
		public static final String POST = "POST";
	}

}
