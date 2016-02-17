package com.weixin.message.bean;

public class WXImageReqMessage extends WXBaseMessage{
	/*PicUrl	图片链接
	MediaId	图片消息媒体id，可以调用多媒体文件下载接口拉取数据。*/
	private String PicUrl;
	private String MediaId;
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	
}
