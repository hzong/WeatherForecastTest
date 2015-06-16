/**   
* @title Image.java 
* @package com.example.android.tags.listview.entity 
* @describe TODO
* @author hzong
* @datetime 2015-5-18 下午8:41:49 
* @version v1.0   
*/ 
package com.example.android.tags.listview.entity;

import com.example.android.util.DateTimeUtil;


/** 
 * @className  ImageText 
 * @describe 预报实体
 * @author  hzong
 * @datetime  2015-5-18 下午8:41:49  
 */
public class Forecast {
	/** 
	* @fieldName tv_name
	* @describe 名称
	* @fieldType String
	*/ 
	String forecast_name;
	/** 
	* @fieldName tv_time
	* @describe 时间
	* @fieldType String
	*/ 
	String forecast_time;
	/** 
	* @fieldName week
	* @describe 一周
	* @fieldType boolean[]
	*/ 
	int[] week;
	/** 
	* @fieldName is_use
	* @describe 是否使用
	* @fieldType boolean
	*/ 
	boolean is_use;
	public String getForecast_name() {
		
		return forecast_name == null ? "预告":forecast_name;
	}
	public void setForecast_name(String forecast_name) {
		
		this.forecast_name = forecast_name;
	}
	public String getForecast_time() {
		return forecast_time == null ? DateTimeUtil.getDateFormat(DateTimeUtil.FORMAT_TIME) :forecast_time;
	}
	public void setForecast_time(String forecast_time) {
		this.forecast_time = forecast_time;
	}
	public int[] getWeek() {
		return week;
	}
	public void setWeek(int[] week) {
		this.week = week;
	}
	public boolean isIs_use() {
		return is_use;
	}
	public void setIs_use(boolean is_use) {
		this.is_use = is_use;
	}
	
	
}
