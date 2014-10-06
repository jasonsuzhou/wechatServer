package com.mh.wechat.entity;

import java.util.Date;

import com.mh.wechat.constants.Const;
import com.mh.wechat.util.WeChatUtil;

public class AccessToken {

	private final static String ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	private static AccessToken instance = new AccessToken();

	/**
	 * The token return from wechat
	 */
	private String accessToken;
	/**
	 * The expire time of the token, default 7200 seconds
	 */
	private long expiresIn = 7200;

	/**
	 * The time when get the access token
	 */
	private long retrieveTime = -1;

	public static AccessToken getInstance() {
		return instance.genToken();
	}

	private boolean isExpired() {
		long current = new Date().getTime();
		return -1 == retrieveTime ? true : (current - retrieveTime >= expiresIn * 1000 ? true : false);
	}

	/**
	 * Global access token<br/>
	 * This token will need when you invoke the API provided by wechat
	 * 
	 * @return
	 */
	private AccessToken genToken() {
		if (this.isExpired()) {
			String requestUrl = ACCESS_TOKEN.replace("APPID", Const.APP_ID).replace("APPSECRET", Const.APP_SECRET);
			WeChatResponse response = WeChatUtil.sendHttpsRequest(requestUrl, Const.RequestMethod.GET, null);
			this.accessToken = response.getAccess_token();
			this.expiresIn = Long.valueOf(response.getExpires_in());
			this.retrieveTime = new Date().getTime();
		}
		return this;
	}

	public String getAccessToken() {
		return accessToken;
	}

}
