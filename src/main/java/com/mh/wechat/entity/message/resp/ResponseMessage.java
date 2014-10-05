package com.mh.wechat.entity.message.resp;

public class ResponseMessage {

	/**
	 * The message who will send to
	 */
	private String ToUserName;
	/**
	 * The official account of the development
	 */
	private String FromUserName;

	/**
	 * The create time of the message which is numeric
	 */
	private long CreateTime;

	/**
	 * The message type
	 * 
	 * @see com.mh.wechat.constants.Const.MessageType
	 */
	private String MsgType;

	/**
	 * The message id which is 64 length numeric
	 */
	private long MsgId;

	/**
	 * if 0x0001 marked means is new message
	 */
	private int FuncFlag;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public long getMsgId() {
		return MsgId;
	}

	public void setMsgId(long msgId) {
		MsgId = msgId;
	}

	public int getFuncFlag() {
		return FuncFlag;
	}

	public void setFuncFlag(int funcFlag) {
		FuncFlag = funcFlag;
	}

}
