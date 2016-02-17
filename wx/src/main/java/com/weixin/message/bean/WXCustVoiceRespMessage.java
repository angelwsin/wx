package com.weixin.message.bean;

public class WXCustVoiceRespMessage extends WXCustBaseRespMessage{
           private  WXCustVoiceMessage voice;

		public WXCustVoiceMessage getVoice() {
			return voice;
		}

		public void setVoice(WXCustVoiceMessage voice) {
			this.voice = voice;
		}
           
}
