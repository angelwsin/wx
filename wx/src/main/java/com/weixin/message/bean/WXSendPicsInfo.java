package com.weixin.message.bean;

import java.util.List;
public class WXSendPicsInfo {
	/*Count 	发送的图片数量
	PicList 	图片列表
	PicMd5Sum 	图片的MD5值，开发者若需要，可用于验证接收到图片 */
	private int  Count;
	private  List<WXSendPicsInfoItem> PicList  ;
	public int getCount() {
		return Count;
	}
	public void setCount(int count) {
		Count = count;
	}
	public List<WXSendPicsInfoItem> getPicList() {
		return PicList;
	}
	public void setPicList(List<WXSendPicsInfoItem> picList) {
		PicList = picList;
	}
	
	
	
	
	
}
