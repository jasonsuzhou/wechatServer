package com.mh.wechat.entity;

import com.mh.wechat.util.WeChatUtil;

/**
 * mapping to the wechat server authentication data
 * 
 * @author jasonyao
 * 
 */
public class Authentication {
	/**
	 * this is encrypted by SHA-1 wechat server when he send to me
	 */
	private String signature;
	/**
	 * date time when to call me
	 */
	private String timestamp;
	/**
	 * the random number send to me
	 */
	private String nonce;
	/**
	 * the random string send to me
	 */
	private String echostr;

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getNonce() {
		return nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	public String getEchostr() {
		return echostr;
	}

	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}

	/**
	 * check the signature by the token configured inside the wechat backend
	 * console
	 * 
	 * @return true if is valid
	 */
	public boolean pass() {
		return WeChatUtil.checkSignature(this.signature, this.timestamp, this.nonce);
	}

}
