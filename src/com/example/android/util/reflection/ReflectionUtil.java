/**   
* @title ReflectionUtil.java 
* @package com.example.android.util.reflection 
* @describe TODO
* @author hzong
* @datetime 2015-6-15 ����10:03:58 
* @version v1.0   
*/ 
package com.example.android.util.reflection;

import java.lang.reflect.Field;


/** 
 * @className  ReflectionUtil 
 * @describe  ���乤���
 * @author  hzong
 * @datetime  2015-6-15 ����10:03:58  
 */
public class ReflectionUtil {
	
	
	/** 
	* @title getField 
	* @describe ��ȡ����int ֵ
	* @param obj ����
	* @param fieldName ��������
	* @return ���ر���ֵ
	* @author hzong 
	*/ 
	public static int getField(Class<?> obj,String fieldName){
		Field field;
		int val = 0;
		try {
			field = obj.getField(fieldName);
			val =field.getInt(obj.newInstance());
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return val;
	}
}
