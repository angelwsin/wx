package com.weixin.message.bean;

public class WXCustNewsRespMessage extends WXCustBaseRespMessage {
         private WXCustNewsMessage  news;

		public WXCustNewsMessage getNews() {
			return news;
		}

		public void setNews(WXCustNewsMessage news) {
			this.news = news;
		}
         
}
