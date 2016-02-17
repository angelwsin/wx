package com.weixin.message.bean;

public class WXCustBaseRespMessage {
	/*touser 	是 	普通用户openid
	msgtype 	是 	消息类型，
	文本为text，图片为image，语音为voice，
	视频消息为video，音乐消息为music，图文消息为news，卡券为wxcard */
	private String touser;
	private String msgtype;
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	
}
