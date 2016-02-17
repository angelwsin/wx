package com.weixin.message.bean;

public class WXCustMusicRespMessage extends WXCustBaseRespMessage {
          private  WXCustMusicMessage music;

		public WXCustMusicMessage getMusic() {
			return music;
		}

		public void setMusic(WXCustMusicMessage music) {
			this.music = music;
		}
          
}
