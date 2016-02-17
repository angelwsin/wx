package com.weixin.message.bean;

import java.util.ArrayList;
import java.util.List;

public class WXNewsRespMessage extends WXMessage{
	/*ArticleCount	是	图文消息个数，限制为10条以内*/
	private int ArticleCount;
    private List<WXNewItmesMessage> Articles = new ArrayList<WXNewItmesMessage>();;
	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public List<WXNewItmesMessage> getArticles() {
		return Articles;
	}

	public void setArticles(List<WXNewItmesMessage> articles) {
		Articles.addAll(articles);
	}
	public void addNewItmes(WXNewItmesMessage newItmes) {
		Articles.add(newItmes);
	}
	
	
	
}
