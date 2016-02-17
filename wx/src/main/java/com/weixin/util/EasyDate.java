package com.weixin.util;
/*package com.taskjob.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class EasyDate
  implements Comparable<Object>, Cloneable, Serializable
{
  public static final String DATE = "yyyy-MM-dd";
  public static final String DATETIME = "yyyy-MM-dd HH:mm:ss";
  public static final String SHORT_DATE = "yyyyMMdd";
  public static final String YM_DATE = "yyyyMM";
  public static final String GMT_DATE = "d MMM yyyy HH:mm:ss 'GMT'";
  public static final String GMT_NET_DATE = "EEE, d MMM yyyy HH:mm:ss 'GMT'";
  private static final long serialVersionUID = 1L;
  private Calendar calendar;
  
  protected void setCalendar(Calendar calendar)
  {
    this.calendar = calendar;
    this.calendar.setLenient(false);
    this.calendar.setFirstDayOfWeek(2);
  }
  
  public EasyDate(java.util.Date date)
  {
    setCalendar(new GregorianCalendar());
    this.calendar.setTimeInMillis(date.getTime());
  }
  
  public EasyDate()
  {
    setCalendar(new GregorianCalendar());
  }
  
  public EasyDate(long date)
  {
    setCalendar(new GregorianCalendar());
    this.calendar.setTimeInMillis(date);
  }
  
  private EasyDate(Object date, int offsetYear, int offsetMonth, int offsetDay)
  {
    this(getTimeOfDate(date));
    if (offsetYear != 0) {
      this.calendar.add(1, offsetYear);
    }
    if (offsetMonth != 0) {
      this.calendar.add(2, offsetMonth);
    }
    if (offsetDay != 0) {
      this.calendar.add(5, offsetDay);
    }
  }
  
  public EasyDate(java.util.Date date, int offsetYear, int offsetMonth, int offsetDay)
  {
    this(date, offsetYear, offsetMonth, offsetDay);
  }
  
  public EasyDate(EasyDate date, int offsetYear, int offsetMonth, int offsetDay)
  {
    this(date, offsetYear, offsetMonth, offsetDay);
  }
  
  public EasyDate(Calendar date, int offsetYear, int offsetMonth, int offsetDay)
  {
    this(date, offsetYear, offsetMonth, offsetDay);
  }
  
  private static final long getTimeOfDate(Object date)
  {
    long theTime;
    if (date == null)
    {
      theTime = System.currentTimeMillis();
    }
    else
    {
      long theTime;
      if ((date instanceof java.util.Date))
      {
        theTime = ((java.util.Date)date).getTime();
      }
      else
      {
        long theTime;
        if ((date instanceof EasyDate))
        {
          theTime = ((EasyDate)date).getTime();
        }
        else
        {
          long theTime;
          if ((date instanceof Calendar)) {
            theTime = ((Calendar)date).getTimeInMillis();
          } else {
            throw new ClassCastException("指定的对象不是日期类型：" + date);
          }
        }
      }
    }
    long theTime;
    return theTime;
  }
  
  public EasyDate(int year, int month, int day, int... args)
  {
    int[] theArgs = new int[4];
    for (int i = 0; i < args.length; i++) {
      theArgs[i] = args[i];
    }
    setCalendar(new GregorianCalendar(year, month - 1, day, theArgs[0], theArgs[1], theArgs[2]));
    this.calendar.set(14, theArgs[3]);
  }
  
  public int getYear()
  {
    return this.calendar.get(1);
  }
  
  public EasyDate setYear(int year)
  {
    this.calendar.set(1, year);
    return this;
  }
  
  public EasyDate addYear(int year)
  {
    this.calendar.add(1, year);
    return this;
  }
  
  public int getMonth()
  {
    return this.calendar.get(2) + 1;
  }
  
  public EasyDate setMonth(int month)
  {
    this.calendar.set(2, month - 1);
    return this;
  }
  
  public EasyDate addMonth(int month)
  {
    this.calendar.add(2, month);
    return this;
  }
  
  public EasyDate set(int year, int month, int day, int... args)
  {
    this.calendar.set(1, year);
    this.calendar.set(2, month - 1);
    this.calendar.set(5, day);
    if (args.length > 0)
    {
      int[] fields = { 11, 12, 13, 14 };
      int i = 0;
      do
      {
        this.calendar.set(fields[i], args[i]);
        i++;
      } while (
      
        i < args.length);
    }
    return this;
  }
  
  public int getDay()
  {
    return this.calendar.get(5);
  }
  
  public int getDayOfYear()
  {
    return this.calendar.get(6);
  }
  
  public EasyDate setDay(int day)
  {
    this.calendar.set(5, day);
    return this;
  }
  
  public EasyDate addDay(int day)
  {
    this.calendar.add(5, day);
    return this;
  }
  
  public int getWeekDay()
  {
    int weekday = this.calendar.get(7);
    weekday--;return weekday == 1 ? 7 : weekday;
  }
  
  public int getHour()
  {
    return this.calendar.get(11);
  }
  
  public EasyDate setHour(int hour)
  {
    this.calendar.set(11, hour);
    return this;
  }
  
  public EasyDate addHour(int hour)
  {
    this.calendar.add(11, hour);
    return this;
  }
  
  public int getMinute()
  {
    return this.calendar.get(12);
  }
  
  public EasyDate setMinute(int minute)
  {
    this.calendar.set(12, minute);
    return this;
  }
  
  public EasyDate addMinute(int minute)
  {
    this.calendar.add(12, minute);
    return this;
  }
  
  public int getSecond()
  {
    return this.calendar.get(13);
  }
  
  public EasyDate setSecond(int second)
  {
    this.calendar.set(13, second);
    return this;
  }
  
  public EasyDate addMillisecond(int ms)
  {
    this.calendar.add(14, ms);
    return this;
  }
  
  public int getMillisecond()
  {
    return this.calendar.get(14);
  }
  
  public EasyDate setMillisecond(int ms)
  {
    this.calendar.set(14, ms);
    return this;
  }
  
  public EasyDate addSecond(int second)
  {
    this.calendar.add(13, second);
    return this;
  }
  
  public long getTime()
  {
    return this.calendar.getTimeInMillis();
  }
  
  public EasyDate setTime(long date)
  {
    this.calendar.setTimeInMillis(date);
    return this;
  }
  
  public EasyDate addTime(long time)
  {
    this.calendar.setTimeInMillis(this.calendar.getTimeInMillis() + time);
    return this;
  }
  
  public void setDate(java.util.Date date)
  {
    this.calendar.setTime(date);
  }
  
  public int getWeeksOfMonth()
  {
    return this.calendar.get(4);
  }
  
  public int getWeeksOfYear()
  {
    return this.calendar.get(3);
  }
  
  public Calendar getCalendar()
  {
    return this.calendar;
  }
  
  public static EasyDate smartParse(String date)
  {
    if (date == null) {
      throw new NullPointerException("指定的日期字符串不能为null");
    }
    int length = date.length();
    String format = null;
    switch (length)
    {
    case 10: 
      format = "yyyy-MM-dd";
      break;
    case 19: 
      format = "yyyy-MM-dd HH:mm:ss";
      break;
    case 8: 
      format = "yyyyMMdd";
      break;
    case 6: 
      format = "yyyyMM";
      break;
    default: 
      throw new IllegalArgumentException("智能转换日期字符串时无法找到对应的DateFormat.");
    }
    return parse(format, date);
  }
  
  public static final EasyDate valueOf(java.util.Date date)
  {
    if (date == null) {
      return null;
    }
    return new EasyDate(date.getTime());
  }
  
  public static final EasyDate valueOf(Calendar date)
  {
    if (date == null) {
      return null;
    }
    return new EasyDate(date.getTime());
  }
  
  public static final EasyDate valueOf(String date)
  {
    if (date == null) {
      return null;
    }
    return smartParse(date);
  }
  
  public static EasyDate parse(DateFormat format, String date)
  {
    try
    {
      return new EasyDate(format.parse(date).getTime());
    }
    catch (ParseException e)
    {
      throw new IllegalArgumentException(e);
    }
  }
  
  public static EasyDate parse(String format, String date)
  {
    DateFormat dateFormat = new SimpleDateFormat(format);
    try
    {
      return new EasyDate(dateFormat.parse(date));
    }
    catch (ParseException e)
    {
      throw new IllegalArgumentException("无法将指定的日期字符串[" + date + "]使用SimpleDateFormat按照指定的格式[" + format + "]转为日期对象");
    }
  }
  
  public java.util.Date toDate()
  {
    return new java.util.Date(this.calendar.getTimeInMillis());
  }
  
  public java.sql.Date toSqlDate()
  {
    return new java.sql.Date(this.calendar.getTimeInMillis());
  }
  
  public Timestamp toTimestamp()
  {
    return new Timestamp(this.calendar.getTimeInMillis());
  }
  
  public Time toTime()
  {
    return new Time(this.calendar.getTimeInMillis());
  }
  
  public int compareTo(Object date)
  {
    if (date == null) {
      throw new NullPointerException("用于比较的指定日期对象不能为null。");
    }
    if (this == date) {
      return 0;
    }
    long diff = this.calendar.getTimeInMillis() - getTimeOfDate(date);
    if (diff == 0L) {
      return 0;
    }
    return diff > 0L ? 1 : -1;
  }
  
  public long calcDifference(Object date, int field, RoundingMode roundingMode)
  {
    long theMillis;
    if ((date instanceof java.util.Date))
    {
      theMillis = ((java.util.Date)date).getTime();
    }
    else
    {
      long theMillis;
      if ((date instanceof EasyDate))
      {
        theMillis = ((EasyDate)date).getTime();
      }
      else
      {
        long theMillis;
        if ((date instanceof Calendar)) {
          theMillis = ((Calendar)date).getTimeInMillis();
        } else {
          throw new IllegalArgumentException("unexpected type of date:" + date);
        }
      }
    }
    long theMillis;
    long diff = getTime() - theMillis;
    if (diff == 0L) {
      return 0L;
    }
    long unit = 1L;
    switch (field)
    {
    case 1: 
    case 2: 
      boolean isMax = diff > 0L;
      EasyDate me = new EasyDate(getTime());
      EasyDate other = new EasyDate(theMillis);
      EasyDate min = isMax ? other : me;
      EasyDate max = isMax ? me : other;
      int diffOfYear = max.getYear() - min.getYear();
      if (diffOfYear > 0) {
        min.addYear(diffOfYear);
      }
      if (field == 2)
      {
        int diffOfMonth = max.getMonth() - min.getMonth();
        if (diffOfMonth != 0) {
          min.addMonth(diffOfMonth);
        }
        diff = diffOfYear * 12 + diffOfMonth;
      }
      else
      {
        diff = diffOfYear;
      }
      long prefix = max.getTime() - min.getTime();
      if (prefix == 0L) {
        return diff;
      }
      long suffix = 0L;
      if (prefix > 0L)
      {
        min.calendar.add(field, 1);
        suffix = min.getTime() - max.getTime();
      }
      else
      {
        suffix = -prefix;
        diff -= 1L;
        min.calendar.add(field, -1);
        prefix = max.getTime() - min.getTime();
      }
      double base = suffix > prefix ? 0.1D : 0.9D;
      diff = new BigDecimal(diff + base).setScale(0, roundingMode).longValue();
      return isMax ? diff : -diff;
    case 5: 
    case 6: 
      unit *= 24L;
    case 10: 
    case 11: 
      unit *= 60L;
    case 12: 
      unit *= 60L;
    case 13: 
      unit *= 1000L;
    case 14: 
      return new BigDecimal(diff).divide(new BigDecimal(unit), roundingMode).longValue();
    }
    throw new IllegalArgumentException("unexpected value of field:" + field);
  }
  
  public long calcDifference(Object date, int field)
  {
    return calcDifference(date, field, RoundingMode.CEILING);
  }
  
  public int calcDifference(Object date)
  {
    return (int)calcDifference(date, 5, RoundingMode.CEILING);
  }
  
  public boolean isLeapYear(int year)
  {
    return ((GregorianCalendar)this.calendar).isLeapYear(year);
  }
  
  public boolean isLeapYear()
  {
    return ((GregorianCalendar)this.calendar).isLeapYear(getYear());
  }
  
  public boolean after(Object date)
  {
    return compareTo(date) > 0;
  }
  
  public int getLastDayOfMonth()
  {
    return this.calendar.getActualMaximum(5);
  }
  
  public EasyDate beginOf(int field)
  {
    switch (field)
    {
    case 1: 
      this.calendar.set(2, 0);
    case 2: 
      this.calendar.set(5, 1);
    case 5: 
      this.calendar.set(11, 0);
    case 11: 
      this.calendar.set(12, 0);
    case 12: 
      this.calendar.set(13, 0);
    case 13: 
      this.calendar.set(14, 0);
      break;
    case 3: 
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    default: 
      throw new IllegalArgumentException("无法识别的日期字段:" + field);
    }
    return this;
  }
  
  public EasyDate setTimeZoneOffset(int minutes)
  {
    StringBuilder timeZoneID = new StringBuilder().append("GMT").append(minutes > 0 ? '+' : '-').append(minutes / 60);
    int min = minutes % 60;
    if (min > 0)
    {
      timeZoneID.append(':');
      if (min < 10) {
        timeZoneID.append('0');
      }
      timeZoneID.append(min);
    }
    this.calendar.getTimeInMillis();
    this.calendar.setTimeZone(TimeZone.getTimeZone(timeZoneID.toString()));
    return this;
  }
  
  public int getTimeZoneOffset()
  {
    TimeZone timeZone = this.calendar.getTimeZone();
    return timeZone.getOffset(this.calendar.getTimeInMillis()) / 60000;
  }
  
  public EasyDate endOf(int field)
  {
    switch (field)
    {
    case 1: 
      this.calendar.set(2, 11);
    case 2: 
      this.calendar.set(5, this.calendar.getActualMaximum(5));
    case 5: 
      this.calendar.set(11, 23);
    case 11: 
      this.calendar.set(12, 59);
    case 12: 
      this.calendar.set(13, 59);
    case 13: 
      this.calendar.set(14, 999);
      break;
    case 3: 
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    default: 
      throw new IllegalArgumentException("无法识别的日期字段:" + field);
    }
    return this;
  }
  
  public boolean before(Object date)
  {
    return compareTo(date) < 0;
  }
  
  public int hashCode()
  {
    int result = 1;
    result = result * 31 + (this.calendar == null ? 0 : this.calendar.hashCode());
    return result;
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof EasyDate)) {
      return false;
    }
    EasyDate other = (EasyDate)obj;
    if ((this.calendar == null) && 
      (other.calendar != null)) {
      return false;
    }
    return this.calendar.equals(other.calendar);
  }
  
  public String toString()
  {
    char[] chars = { '0', '0', '0', '0', '-', '0', '0', '-', '0', '0' };
    setNumberToChars(chars, getYear(), 0, 4);
    setNumberToChars(chars, getMonth(), 5, 2);
    setNumberToChars(chars, getDay(), 8, 2);
    return new String(chars);
  }
  
  public String toString(DateFormat format)
  {
    TimeZone timeZone = this.calendar.getTimeZone();
    if (timeZone.getRawOffset() != TimeZone.getDefault().getRawOffset()) {
      format.setTimeZone(timeZone);
    }
    return format.format(toDate());
  }
  
  public String toLocaleString()
  {
    char[] chars = { '0', '0', '0', '0', '-', '0', '0', '-', '0', '0', ' ', '0', '0', ':', '0', '0', ':', '0', '0' };
    setNumberToChars(chars, getYear(), 0, 4);
    setNumberToChars(chars, getMonth(), 5, 2);
    setNumberToChars(chars, getDay(), 8, 2);
    setNumberToChars(chars, getHour(), 11, 2);
    setNumberToChars(chars, getMinute(), 14, 2);
    setNumberToChars(chars, getSecond(), 17, 2);
    return new String(chars);
  }
  
  public String toShortString()
  {
    char[] chars = { '0', '0', '0', '0', '0', '0', '0', '0' };
    setNumberToChars(chars, getYear(), 0, 4);
    setNumberToChars(chars, getMonth(), 4, 2);
    setNumberToChars(chars, getDay(), 6, 2);
    return new String(chars);
  }
  
  public String toLongString()
  {
    char[] chars = { '0', '0', '0', '0', '-', '0', '0', '-', '0', '0', ' ', '0', '0', ':', '0', '0', ':', '0', '0', ' ', '0', '0', '0' };
    setNumberToChars(chars, getYear(), 0, 4);
    setNumberToChars(chars, getMonth(), 5, 2);
    setNumberToChars(chars, getDay(), 8, 2);
    setNumberToChars(chars, getHour(), 11, 2);
    setNumberToChars(chars, getMinute(), 14, 2);
    setNumberToChars(chars, getSecond(), 17, 2);
    setNumberToChars(chars, getMillisecond(), 20, 3);
    return new String(chars);
  }
  
  public String toGMTString()
  {
    return new SimpleDateFormat("d MMM yyyy HH:mm:ss 'GMT'").format(toDate());
  }
  
  public String toGMTNetString()
  {
    return new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'").format(toDate());
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    EasyDate date = null;
    try
    {
      date = (EasyDate)super.clone();
      if (this.calendar != null) {
        date.calendar = ((Calendar)this.calendar.clone());
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return date;
  }
  
  public static final void setNumberToChars(char[] chars, int number, int start, int length)
  {
    int end = start + length;
    while (length-- > 0)
    {
      chars[(--end)] = Character.forDigit(number % 10, 10);
      number /= 10;
    }
  }
}
*/