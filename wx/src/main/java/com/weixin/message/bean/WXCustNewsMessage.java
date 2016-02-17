package com.weixin.message.bean;

import java.util.ArrayList;
import java.util.List;

public class WXCustNewsMessage {
       private List<WXCustNewsItemsMessage> articles = new ArrayList<WXCustNewsItemsMessage>();

	public List<WXCustNewsItemsMessage> getArticles() {
		return articles;
	}

	public void setArticles(List<WXCustNewsItemsMessage> articles) {
		this.articles.addAll(articles);
	}
	public void addNewsItems(WXCustNewsItemsMessage itmes) {
		this.articles.add(itmes);
	}
       
}
