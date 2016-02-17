package com.weixin.message.bean;

public class WXPicSysPhotoMessage extends WXBaseEventMessage{
/*	SendPicsInfo 	发送的图片信息
	Count 	发送的图片数量
	PicList 	图片列表
	PicMd5Sum 	图片的MD5值，开发者若需要，可用于验证接收到图片 */

	private  WXSendPicsInfo SendPicsInfo;

	public WXSendPicsInfo getSendPicsInfo() {
		return SendPicsInfo;
	}

	public void setSendPicsInfo(WXSendPicsInfo sendPicsInfo) {
		SendPicsInfo = sendPicsInfo;
	}
	
	
	
}
