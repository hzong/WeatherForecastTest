/**   
* @标题: DateTimeUtil.java 
* @包: com.system.util 
* @描述: 无
* @作者: hzong
* @时间：2015-4-6 下午03:50:38 
* @版本：v1.0   
*/ 
package com.example.android.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/** 
 * @类名称: DateTimeUtil 
 * @描述: 日期时间工具
 * @作者: hzong
 * @时间: 2015-4-6 下午03:50:38  
 */
public class DateTimeUtil {
	private static final String S_MIN_YEAR= "2015";
	private static final String S_MAX_YEAR = "2099";
	private static final int I_MIN_YEAR= 2015;
	private static final int I_MAX_YEAR = 2099;
	private static final String FORMAT_YEAR_MONTH="yyyy-MM";
	private static final String FORMAT_DATE="yyyy-MM-dd";
	private static final String FORMAT_DATETIME="yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT_TIME="HH:mm";
	
	
	/** 
	* @标题：InversionMotherDay 
	* @描述：取反日期如
	* 				DateTimeUtil.InversionMotherDay(new String[]{"2015-04-06"});
	* 				结果2015-04-01, 2015-04-02, 2015-04-03, 2015-04-04, 2015-04-05, 2015-04-07, 
	* 				2015-04-08, 2015-04-09, 2015-04-10, 2015-04-11, 2015-04-12, 2015-04-13, 2015-04-14, 
	* 				 2015-04-15, 2015-04-16, 2015-04-17, 2015-04-18, 2015-04-19, 2015-04-20, 2015-04-21, 
	*  				2015-04-22, 2015-04-23, 2015-04-24, 2015-04-25, 2015-04-26, 2015-04-27, 2015-04-28, 
	*  				2015-04-29, 2015-04-30]
	* 
	* @参数：@param a_s_dates
	* @参数：@return 
	* @作者：hzong
	* @返回类型： List<String>     
	* @异常：无 
	*/ 
	public static List<String> InversionMotherDay(List<String> l_s_effective){
		if(l_s_effective == null){
			throw new NullPointerException();
		}
		List<String> l_s_date = new ArrayList<String>();
		Calendar cal = Calendar.getInstance();
		if(l_s_effective.size() > 0){
			try {
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
				cal.setTime(df.parse(l_s_effective.get(0)));
				
			} catch (ParseException e) {
				System.out.println(e.getMessage());
			}
		}
		
		String date_format =  cal.get(Calendar.YEAR)+"-"+String.format("%02d", cal.get(Calendar.MONTH)+1);
		String date_eff  = "";
		int day = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		for(int i = 1;i <=day;i++){
			 date_eff = String.format(date_format+"-%02d", i);
			if(!l_s_effective.contains(date_eff)){
				l_s_date.add(date_eff.trim());
			}
		}
		return l_s_date;
	}
	
	public static List<String> InversionMy97DatePicker(List<String> l_s_effective){
		if(l_s_effective == null){
			throw new NullPointerException();
		}
		List<String> l_s_date = new ArrayList<String>();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
		
		String date_format =  null;
		String date_eff  = "";
		int day = 0;
		
		
		for (int i = I_MIN_YEAR; i <= I_MAX_YEAR; i++) {
			for(int u =0;u<l_s_effective.size();u++){		
				if(l_s_effective.get(u).indexOf(String.valueOf(i)) == -1){
					if(!l_s_date.contains(String.valueOf(i))){
						l_s_date.add(String.valueOf(i));
					}
					
				}else{
					break;
				}
			}
			if(l_s_effective.size() == 0){
				continue;
			}
			if(l_s_date.contains(String.valueOf(i))){
				continue;
			}
			
			
			for (int k = 1; k <= 12; k++) {
				for(int u =0;u<l_s_effective.size();u++){		
					if(l_s_effective.get(u).indexOf(String.valueOf(i)+"-"+String.format("%02d", k)) == -1){
						if(!l_s_date.contains(String.valueOf(i)+"-"+String.format("%02d", k))){
							l_s_date.add(String.valueOf(i)+"-"+String.format("%02d", k));
						}
					}else{
						break;
					}
				}
				if(l_s_date.contains(String.valueOf(i)+"-"+String.format("%02d", k))){
					continue;
				}
				
				try {
					cal.setTime(df.parse(String.valueOf(i)+"-"+String.format("%02d", k)));
				} catch (ParseException e) {
					System.out.println(e.getMessage());
				}
				date_format = cal.get(Calendar.YEAR) + "-" + String.format("%02d", cal.get(Calendar.MONTH) + 1);
				day = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
				for (int j = 1; j <= day; j++) {
					date_eff = String.format(date_format + "-%02d", j);
					if (!l_s_effective.contains(date_eff)) {
						l_s_date.add(date_eff.trim());
					}
				}
			}
		}
		System.out.println(l_s_date.toString());
		return l_s_date;
	}
	
	/**
	 * @title (标题):currentYeadMontheFormat
	 * @description（描述）:当前年月日
	 * @throws(异常): 无
	 * @return(返回值): String  
	 * @date(时间):  Nov 18, 2014 3:31:02 PM
	 * @author(作者): hzong
	 * @version(版本) 1.0
	 */
	public static String currentYeadMontheFormat(){
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
	    return  sdf.format(new Date());
	}
	
	/**
	 * @title (标题):currentDateFormat
	 * @description（描述）:当前年月日
	 * @throws(异常): 无
	 * @return(返回值): String  
	 * @date(时间):  Nov 18, 2014 3:31:02 PM
	 * @author(作者): hzong
	 * @version(版本) 1.0
	 */
	public static String currentDateFormat(){
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    return  sdf.format(new Date());
	}
	
	
	/**
	 * @title (标题):currentDateTimeFormat
	 * @description（描述）:当前年与日时分秒
	 * @throws(异常): 无
	 * @return(返回值): String  
	 * @date(时间):  Nov 18, 2014 3:32:33 PM
	 * @author(作者): hzong
	 * @version(版本) 1.0
	 */
	public static String currentDateTimeFormat(){
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    return  sdf.format(new Date());
	}
	
	/** 
	* @标题：getDateFormat 
	* @描述：自定义当前时间格式
	* @参数：@param s_format 格式
	* @作者：hzong
	* @返回类型： String     
	* @异常：无 
	*/ 
	public static String getDateFormat(String s_format){
	    SimpleDateFormat sdf = new SimpleDateFormat(s_format);
	    return  sdf.format(new Date());
	}
	
	/**
	 * @title (标题):setBackDateTime
	 * @description（描述）: 设置时间
	 * 	Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY,calendar.get(Calendar.HOUR_OF_DAY)-1);
	 * @param calendar 日历类
	 * @param s_format 格式
	 * @throws(异常): 无
	 * @return(返回值): String  
	 * @date(时间):  Nov 25, 2014 4:17:53 PM
	 * @author(作者): hzong
	 * @version(版本) 1.0
	 */
	public static String setBackDateTime(Calendar calendar,String s_format){
	    SimpleDateFormat sdf = new SimpleDateFormat(s_format);
	    return  sdf.format(calendar.getTime());
	}
	
	
	/** 
	* @标题：getYearMillis 
	* @描述：年毫秒
	* @作者：hzong
	* @返回类型： int     毫秒
	* @异常：无 
	*/ 
	public static int getYearMillis(){
		return 365*getDayMillis();
	}
	
	/** 
	* @标题：getMonthMillis 
	* @描述：月毫秒
	* @参数：@param yead_month 如：yyyy-mm
	* @作者：hzong
	* @返回类型： int     毫秒
	* @异常：无 
	*/ 
	public static int getMonthMillis(String yead_month){
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(DateFormat.getInstance().parse(yead_month));
		} catch (ParseException e) {
		}
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH)*getDayMillis();
	}
	
	/** 
	* @标题：getDayMillis 
	* @描述：天毫秒
	* @作者：hzong
	* @返回类型： int     毫秒
	* @异常：无 
	*/ 
	public static int getDayMillis(){
		return getHourMillis()*24;
	}
	
	/** 
	* @标题：getHourMillis 
	* @描述：小时毫秒
	* @作者：hzong
	* @返回类型： int     毫秒
	* @异常：无 
	*/ 
	public static int getHourMillis(){
		return getMinutesMillis()*60;
	}
	
	/** 
	* @标题：getMinutesMillis 
	* @描述：分钟毫秒
	* @作者：hzong
	* @返回类型： int     毫秒
	* @异常：无 
	*/ 
	public static int getMinutesMillis(){
		return getSecondsMillis()*60;
	}
	
	/** 
	* @标题：getSecondsMillis 
	* @描述：秒毫秒
	* @作者：hzong
	* @返回类型： int     毫秒
	* @异常：无 
	*/ 
	public static int getSecondsMillis(){
		return 1000;
	}
	                                    
	
	
	
	public static void main(String[] args) {
		
		DateTimeUtil.InversionMy97DatePicker(Arrays.asList(new String[]{"2015-04-05"}));
	}
}
