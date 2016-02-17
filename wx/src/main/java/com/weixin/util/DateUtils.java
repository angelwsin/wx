package com.weixin.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/*
 * Calendar日期处理类，用来处理日期的设值，获取相应的年，月，日，通过传入Date对象，获取想要的相关，数据，或者获得用Calendar处理后，想要的数据
GregorianCalendar是Calendar的一个具体子类，提供了世界上大多数国家/地区使用的标准日历
系统。
注意：
----月份：一月是0，二月是1，以此类推，12月是11
----星期：周日是1，周一是2，。。。。。周六是7
----Calendar类中有很多常量属性可以用大家来操作日期
 */
public class DateUtils {
	
	 public static final String DATE = "yyyy-MM-dd";
	  public static final String DATETIME = "yyyy-MM-dd HH:mm:ss";
	  public static final String SHORT_DATE = "yyyyMMdd";
	  public static final String YM_DATE = "yyyyMM";
	  public static final String GMT_DATE = "d MMM yyyy HH:mm:ss 'GMT'";
	  public static final String GMT_NET_DATE = "EEE, d MMM yyyy HH:mm:ss 'GMT'";
	  
	  public static Calendar calender =  new GregorianCalendar();
	  /*
	   * 得到日期的星期几 
	   */
	  
	  public static int getWeekDay(Date date)
	  {
          calender.setTime(date);
	    int weekday = calender.get(Calendar.DAY_OF_WEEK);
	   return weekday == 1 ? 7 : weekday;
	  }
	  
	  public static int getYear(Date date){
		  calender.setTime(date);
		  return calender.get(Calendar.YEAR);
	  }
	  public static int getDay(Date date){
		  calender.setTime(date);
		  return calender.get(Calendar.DAY_OF_MONTH);
	  }
	  public static int getMonth(Date date){
		  calender.setTime(date);
		  return calender.get(Calendar.MONTH)+1;
	  }
	  public static int getHour(Date date){
		  calender.setTime(date);
		  return calender.get(Calendar.HOUR);
	  }
	  public static int getMinute(Date date){
		  calender.setTime(date);
		  return calender.get(Calendar.MINUTE);
	  }
	  public static int getSecond(Date date){
		  calender.setTime(date);
		  return calender.get(Calendar.SECOND);
	  }
	  public static int getMilliSecond(Date date){
		  calender.setTime(date);
		  return calender.get(Calendar.MILLISECOND);
	  }
	  
	  public static Calendar setYear(Date date,int year){
		  calender.setTime(date);
		  calender.set(Calendar.YEAR,year);
		  return calender;
	  }
	  
	  
	  /*public static int  compareTo(Date start,Date end,int field){
		           switch (field) {
				case Calendar.YEAR:
					       calender.setTime(start);
					break;

				default:
					break;
				}
	  }*/
	  
	  public static void main(String[] args) {
		         System.out.println(getDay(new Date()));
	}

}
