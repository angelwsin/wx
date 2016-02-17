package com.weixin.message.bean;

public class WXSubscribeEventMessage extends WXBaseEventMessage{
	/*EventKey	事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id
	Ticket	二维码的ticket，可用来换取二维码图片*/
	private String Ticket;
	
	public String getTicket() {
		return Ticket;
	}
	public void setTicket(String ticket) {
		Ticket = ticket;
	}

}
