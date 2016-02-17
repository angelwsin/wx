package com.weixin.message.bean;

public class WXCustTextRespMessage extends WXCustBaseRespMessage{
                   private  WXCustTextMessage text;

				public WXCustTextMessage getText() {
					return text;
				}

				public void setText(WXCustTextMessage text) {
					this.text = text;
				}
                   
}
