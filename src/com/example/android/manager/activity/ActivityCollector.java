/**   
* @title activityCollector.java 
* @package com.example.uicustom.manager.activity 
* @describe TODO
* @author hzong
* @datetime 2015-5-14 ����8:42:43 
* @version v1.0   
*/ 
package com.example.android.manager.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

/** 
 * @className  activityCollector 
 * @describe  ����������
 * @author  hzong
 * @datetime  2015-5-14 ����8:42:43  
 */
public class ActivityCollector {
	private static List<Activity> activities = new ArrayList<Activity>();
	
	/** 
	* @title addActivity 
	* @describe ��ӻ
	* @param activity �
	* @author hzong 
	*/ 
	public static void addActivity(Activity activity){
		activities.add(activity);
	}
	/** 
	* @title removeActivity 
	* @describe �Ƴ��
	* @param activity �
	* @author hzong 
	*/ 
	public static void removeActivity(Activity activity){
		activities.remove(activity);
	}
	/** 
	* @title finishAll 
	* @describe �������л
	* @author hzong 
	*/ 
	public static void finishAll(){
		for(Activity activity : activities){
			if(!activity.isFinishing()){
				activity.finish();
			}
		}
	}
}
