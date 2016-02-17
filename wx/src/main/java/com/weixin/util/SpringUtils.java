package com.weixin.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringUtils implements ApplicationContextAware{
	
	  
	  private static ApplicationContext applicationContext;
	
	   
	   public static boolean isNotBlank(String beanName){
		   
		     return  applicationContext.containsBean(beanName);
	   }
	   
	   public static Object getBean(String name){
		    return applicationContext.getBean(name);
	   }

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		SpringUtils.applicationContext = applicationContext;
	}

	
	  
	  
	  
	  
	
	   
	

}
