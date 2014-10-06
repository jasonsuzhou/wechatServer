package com.mh.wechat.entity.message.req;

import com.mh.wechat.constants.Const;

public class EventMessage extends RequestMessage {

	private String Event;
	private String EventKey;

	@Override
	public String getMsgType() {
		return Const.MessageType.EVENT;
	}

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

}
