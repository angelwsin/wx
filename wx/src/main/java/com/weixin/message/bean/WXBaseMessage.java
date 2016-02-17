package com.weixin.message.bean;

public class WXBaseMessage extends WXMessage{
	
	   public static final String MSG_TEXT ="text";
	   public static final String MSG_IMAGE ="image ";
	   public static final String MSG_VOICE ="voice";
	   public static final String MSG_VIDEO ="video";
	   public static final String MSG_SHORT_VIDEO ="shortvideo";
	   public static final String MSG_LOCATION ="location ";
	   public static final String MSG_LINK ="link";
	   public static final String MSG_NEWS="news";
	private long     MsgId;
	public long getMsgId() {
		return MsgId;
	}
	public void setMsgId(long msgId) {
		MsgId = msgId;
	}
}
