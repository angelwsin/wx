package com.weixin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class WXHomeController extends BaseController{
	                   @RequestMapping("/login")
	                   public String login(){
	                	   return "login";
	                   }

}
