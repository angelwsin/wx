package com.weixin.message.bean;

public class WXCustMusicMessage {
/*	thumb_media_id 	是 	缩略图的媒体ID
	title 	否 	图文消息/视频消息/音乐消息的标题
	description 	否 	图文消息/视频消息/音乐消息的描述
	musicurl 	是 	音乐链接
	hqmusicurl 	是 	高品质音乐链接，wifi环境优先使用该链接播放音乐*/
	private  String thumb_media_id;
	private String title;
	private String description;
	private String musicurl;
	private String hqmusicurl;
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
	public String getMusicurl() {
		return musicurl;
	}
	public void setMusicurl(String musicurl) {
		this.musicurl = musicurl;
	}
	public String getHqmusicurl() {
		return hqmusicurl;
	}
	public void setHqmusicurl(String hqmusicurl) {
		this.hqmusicurl = hqmusicurl;
	}
	
}
