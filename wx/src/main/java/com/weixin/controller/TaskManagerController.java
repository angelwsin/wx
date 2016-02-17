package com.weixin.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weixin.bean.ScheduleJob;
import com.weixin.service.ScheduleJobService;
import com.weixin.service.task.SchedulerTaskService;
import com.weixin.util.AjaxMessage;


@Controller
@RequestMapping(value="/taskManager")
public class TaskManagerController extends BaseController{
	       private static final Logger LOGGER =  LoggerFactory.getLogger(TaskManagerController.class);
	         @Autowired
	         private SchedulerTaskService  secheulerTaskService;
	         @Autowired
	         private  ScheduleJobService scheduleJobService;
	         @RequestMapping(value="/{op}",method=RequestMethod.GET)
	         public String taskManger(HttpServletRequest request,@PathVariable("op") String op){
	        	   
	        	    	 if(BaseController.QUERY.equals(op)){
	        	    		
							
								try {
									request.setAttribute("jobList", scheduleJobService.getAll());
									request.setAttribute("runingList",secheulerTaskService.getRunningJob() );
								} catch (SchedulerException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								return "taskManager/task";
							
	        	    	 }else if(BaseController.ADD.equals(op)){
	        	    		 request.setAttribute("op", BaseController.ADD);
	        	    		 return "taskManager/task_add";
	        	    	 }
	        	    	
	        	     return  null;
	        	    
	         }
	         
	         @RequestMapping(value="/add/Update",method=RequestMethod.POST)
	         public String addAndUpdate(HttpServletRequest request,HttpServletResponse response,ScheduleJob job){
	        	 String op = request.getParameter("op");
	        	 if(BaseController.ADD.equals(op)){
        	    	 job.setCreateTime(new Date());
        	    	 job.setUpdateTime(new Date());
        	    	 job.setIsConcurrent(ScheduleJob.CONCURRENT_NOT);
        	    	 job.setJobStatus(ScheduleJob.STATUS_RUNNING);
        	    	 scheduleJobService.save(job);
        	     }
        	     
        	     return "redirect:/taskManager/query";
	         }
	         
	         @RequestMapping("/task/{id}/{status}")
	         public String taskManager(@PathVariable("id")long id ,@PathVariable("status") String satus,HttpServletResponse response){
	        	 ScheduleJob job = new ScheduleJob();
	        	  job.setJobId(id);
	        	        if(ScheduleJob.STATUS_NOT_RUNNING.equals(satus)){
	        	        	System.out.println("extcute ");
	        	        	scheduleJobService.execute(job);
	        	        }else{
	        	        	scheduleJobService.stop(job);
	        	        }
	        	     //  boolean flag =  ScheduleJob.STATUS_NOT_RUNNING.equals(satus);
	        	    // writeJson(response, new AjaxMessage(flag?"1":"0",flag?"启动成功":"停止成功", null));
	        	    
	        	   return  "redirect:/taskManager/query";
	         }
	         
	         @RequestMapping(value="/task/editTime",method=RequestMethod.POST)
	         public String editTime(HttpServletResponse response,ScheduleJob job){
	        	 scheduleJobService.updateTime(job);
	        	 writeJson(response, new AjaxMessage("修改完成"));
	        	 return null;
	         }
	         
	         
	         
	         

}
