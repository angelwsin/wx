package com.weixin.service;

import org.springframework.context.ApplicationContextAware;

import com.weixin.message.bean.WXMessage;

public interface WXMessageService extends ApplicationContextAware{

	
	public void onMessage(WXMessage message);
}
