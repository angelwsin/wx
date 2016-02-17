package com.weixin.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weixin.util.StringUtils;

@Controller
@RequestMapping(value="/WXMenu")
public class WXMenuController extends BaseController{
	
	       @RequestMapping(value="/add")
	      public String add(HttpServletRequest request,HttpServletResponse response){
	    	   System.out.println("--------------------");
	    	   if(!isPost(request)){
	    		   return "menu/menu_add";
	    	   }
	    	 //  request.setAttribute("access_token", TokenService.acessToken());
	    	   System.out.println(request.getParameter("access_token"));
	    	   System.out.println(request.getParameter("body"));
	    	   try {
				System.out.println(StringUtils.streamToString(request.getInputStream()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	   writeToResponse(response, "ok");
	    	  return null;
	      }

}
