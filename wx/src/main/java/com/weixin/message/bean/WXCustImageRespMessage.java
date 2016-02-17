package com.weixin.message.bean;

public class WXCustImageRespMessage extends WXCustBaseRespMessage{
             private WXCustImageMessage image;

			public WXCustImageMessage getImage() {
				return image;
			}

			public void setImage(WXCustImageMessage image) {
				this.image = image;
			}
             
}
