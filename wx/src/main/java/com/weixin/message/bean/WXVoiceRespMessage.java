package com.weixin.message.bean;

public class WXVoiceRespMessage extends WXMessage{
	/*MediaId	是	通过素材管理接口上传多媒体文件，得到的id*/
	 private WXVoiceMessage Voice;

	public WXVoiceMessage getVoice() {
		return Voice;
	}

	public void setVoice(WXVoiceMessage voice) {
		Voice = voice;
	}
	 
}
