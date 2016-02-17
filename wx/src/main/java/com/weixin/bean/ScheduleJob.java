package com.weixin.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*
 *  注意：jobName 跟 groupName的组合应该是唯一的,beanClass springId至少有一个
 */
@SuppressWarnings("serial")
@Entity
@Table(name="task_wx")
public class ScheduleJob {
	
	/*
	 * 任务的状态  可用来暂停 取消 恢复
	 */
	public static final String STATUS_RUNNING = "1";  
    public static final String STATUS_NOT_RUNNING = "0";  
    public static final String CONCURRENT_IS = "1";  
    public static final String CONCURRENT_NOT = "0";  
    
    
    private Long jobId;  
  
    private Date createTime;  
  
    private Date updateTime;  
    /** 
     * 任务名称 
     */  
    private String jobName;  
    /** 
     * 任务分组 
     */  
    private String jobGroup;  
    /** 
     * 任务状态 是否启动任务 
     */  
    private String jobStatus;  
    /** 
     * cron表达式 
     */  
    private String cronExpression;  
    /** 
     * 描述 
     */  
    private String description;  
    /** 
     * 任务执行时调用哪个类的方法 包名+类名 
     */  
    
    private String beanClass;  
    /** 
     * 任务是否有状态 
     */  
    private String isConcurrent;  
    /** 
     * spring bean 
     */  
    private String springId;  
    /** 
     * 任务调用的方法名 
     */  
    private String methodName;
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
	public Long getJobId() {
		return jobId;
	}
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	 @Column(name = "createTime",  nullable = false)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	 @Column(name = "updateTime",  nullable = false)
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Column(name = "jobName",  unique = true,nullable = false)
	public String getJobName() {
		return jobName;
	}
	
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	@Column(name = "jobGroup",unique = true,  nullable = false)
	public String getJobGroup() {
		return jobGroup;
	}
	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}
	@Column(name = "jobStatus",  nullable = false)
	public String getJobStatus() {
		return jobStatus;
	}
	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}
	@Column(name = "cronExpression",  nullable = false)
	public String getCronExpression() {
		return cronExpression;
	}
	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}
	@Column(name = "description",  nullable = false)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name = "beanClass",  nullable = false)
	public String getBeanClass() {
		return beanClass;
	}
	public void setBeanClass(String beanClass) {
		this.beanClass = beanClass;
	}
	@Column(name = "isConcurrent",  nullable = false)
	public String getIsConcurrent() {
		return isConcurrent;
	}
	public void setIsConcurrent(String isConcurrent) {
		this.isConcurrent = isConcurrent;
	}
	@Column(name = "springId",  nullable = false)
	public String getSpringId() {
		return springId;
	}
	public void setSpringId(String springId) {
		this.springId = springId;
	}
	@Column(name = "methodName",  nullable = false)
	public String getMethodName() {
		return methodName;
	}
	
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}  
	
	
    
    

}
