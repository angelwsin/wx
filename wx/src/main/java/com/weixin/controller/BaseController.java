package com.weixin.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.weixin.util.JSONUtil;


@Controller
public class BaseController {
	   public static final  String EDIT ="edit";
	   public static final  String ADD ="add";
	   public static final String DEL ="delete";
	   public static final String QUERY ="query";
	   
	     public   boolean  isPost(HttpServletRequest request){
	    	  return "POST".equals(request.getMethod());
	     }
	     
	     public void writeJson(HttpServletResponse response, Object object) {

	 		if (object != null) {
	 			writeToResponse(response, JSONUtil.encode(object), "utf-8");
	 		}

	 	}

	 	protected static void writeToResponse(HttpServletResponse response, String text,String encoding) {
	 		response.setContentType("text/html;charset=" + encoding);
	 		try {
	 			response.getWriter().write(text);
	 		} catch (IOException e) {
	 			throw new IllegalStateException(e);
	 		}
	 	}

	 	public static void  writeToResponse(HttpServletResponse response, String text) {
	 		writeToResponse(response, text, "utf-8");
	 	}
	 	
	 	 public static void main(String[] args) throws Exception{
	    	  File f = new File ("d:\\json.txt");
	    	  String s =  null;
	    	  BufferedReader re = new BufferedReader(new FileReader(f));
	    	  StringBuffer b  =new StringBuffer();
	    	  while((s=re.readLine())!=null){
	    		  b.append(s);
	    	  }
			  JSONObject.parseObject(b.toString());
			  
		}
	 	
	 	

}
