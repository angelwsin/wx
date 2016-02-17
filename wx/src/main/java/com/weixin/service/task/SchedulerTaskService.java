package com.weixin.service.task;

import java.util.List;

import org.quartz.SchedulerException;

import com.weixin.bean.ScheduleJob;

public interface SchedulerTaskService {
	
	
	/** 
    * 添加任务 
    *  
    * @param scheduleJob 
    * @throws SchedulerException 
    */  
   public void addJob(ScheduleJob job) throws SchedulerException ;
   
   /**  
   * 获取所有计划中的任务列表  
   *   
   * @return  
   * @throws SchedulerException  
   */  
  public List<ScheduleJob> getAllJob() throws SchedulerException ;

  /** 
   * 所有正在运行的job 
   *  
   * @return 
   * @throws SchedulerException 
   */  
  public List<ScheduleJob> getRunningJob() throws SchedulerException ;

  /** 
   * 暂停一个job 
   *  
   * @param scheduleJob 
   * @throws SchedulerException 
   */  
  public void pauseJob(ScheduleJob scheduleJob) throws SchedulerException ;

  /** 
   * 恢复一个job 
   *  
   * @param scheduleJob 
   * @throws SchedulerException 
   */  
  public void resumeJob(ScheduleJob scheduleJob) throws SchedulerException ;

  /** 
   * 删除一个job 
   *  
   * @param scheduleJob 
   * @throws SchedulerException 
   */  
  public void deleteJob(ScheduleJob scheduleJob) throws SchedulerException ;

  /** 
   * 立即执行job 
   *  
   * @param scheduleJob 
   * @throws SchedulerException 
   */  
  public void runAJobNow(ScheduleJob scheduleJob) throws SchedulerException ;

  /** 
   * 更新job时间表达式 
   *  
   * @param scheduleJob 
   * @throws SchedulerException 
   */  
  public void updateJobCron(ScheduleJob scheduleJob) throws SchedulerException;
   
  

}
