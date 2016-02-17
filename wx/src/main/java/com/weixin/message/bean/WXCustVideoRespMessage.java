package com.weixin.message.bean;

public class WXCustVideoRespMessage extends WXCustBaseRespMessage{
           private WXCustVideoMessage video;

		public WXCustVideoMessage getVideo() {
			return video;
		}

		public void setVideo(WXCustVideoMessage video) {
			this.video = video;
		}
           
}
