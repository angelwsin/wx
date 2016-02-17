package com.weixin.message.bean;

public class WXBaseEventMessage extends WXMessage{
	/*Event	事件类型，subscribe(订阅)、unsubscribe(取消订阅)*/
       private String Event;
       private  String EventKey;

   	public String getEventKey() {
   		return EventKey;
   	}

   	public void setEventKey(String eventKey) {
   		EventKey = eventKey;
   	}

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}
       
}
