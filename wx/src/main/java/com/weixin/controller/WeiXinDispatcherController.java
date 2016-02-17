package com.weixin.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weixin.message.bean.WXMessage;
import com.weixin.service.WXMessageService;
import com.weixin.util.StringUtils;
import com.weixin.util.WXMessageFactory;


@Controller
public class WeiXinDispatcherController extends BaseController{
	
	private static final Logger LOGGER = LogManager.getLogger(WeiXinDispatcherController.class);
	@Autowired
	private WXMessageService wxMessageService;
	
	         @RequestMapping(value="/wxDispatcher")
	         public String  wxSignature(HttpServletRequest request,HttpServletResponse response){
	        	// TODO Auto-generated method stub
	        	 if(!isPost(request)){
	        		 doGet(request, response);
	        	 }else{
	        		  doPost(request, response);
	        	 }
	        	   return null;
	         }
	         /*
	          * 微信接口接入验证
	          */
	       private void doGet(HttpServletRequest request,HttpServletResponse response){
	    	   String signature = request.getParameter("signature");
	  	       String timestamp = request.getParameter("timestamp");
	  	       String nonce = request.getParameter("nonce");
	  	       String echostr = request.getParameter("echostr");
	  	     LOGGER.info(signature);
	  	     LOGGER.info(timestamp);
	  	     LOGGER.info(nonce);
	  	     LOGGER.info(echostr);
	  	       if(StringUtils.wxCheckSignature(signature, timestamp, nonce, StringUtils.Token)){
	  	    	 writeToResponse(response, echostr);
	  	       }
	       }
	       /*
	        * 微信接口的入口
	        */
	       private void doPost(HttpServletRequest request,HttpServletResponse response){
	    	     
	    	   try {
			 WXMessage msg = 	WXMessageFactory.getMessageInstance(request.getInputStream());
			 msg.setResponse(response);
			 wxMessageService.onMessage(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	       }

	    	
	  
}
