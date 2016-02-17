package com.dubbo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.weixin.service.WXMessageService;
import com.znn.provider.DemoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext-*.xml")
@Configuration("classpath*:spring-servlet.xml")
public class DubboTest {
      
	@Autowired
	  private  DemoService demoService;
	 @Autowired
     private ApplicationContext applicationContext;
	 @Autowired
	 private WXMessageService wxMessageService;
	@Test
	public void   say(){
		DemoService  s = 	(DemoService) applicationContext.getBean("demoService");
	//	System.out.println(s.sayHello("world--"));
	//	System.out.println(demoService.sayHello("world"));
		wxMessageService.onMessage(null);
	}
}
