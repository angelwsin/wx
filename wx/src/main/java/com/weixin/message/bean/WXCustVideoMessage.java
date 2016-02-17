package com.weixin.message.bean;

public class WXCustVideoMessage {
//	media_id 	是 	发送的图片/语音/视频的媒体ID
//	thumb_media_id 	是 	缩略图的媒体ID
//	title 	否 	图文消息/视频消息/音乐消息的标题
//	description 	否 	图文消息/视频消息/音乐消息的描述 
	private String media_id;
	private String thumb_media_id;
	private String title;
	private String description;
	public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	public String getThumb_media_id() {
		return thumb_media_id;
	}
	public void setThumb_media_id(String thumb_media_id) {
		this.thumb_media_id = thumb_media_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
