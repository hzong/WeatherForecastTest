/**   
* @title ORMSQLiteTable.java 
* @package com.example.android.util.reflection.orm 
* @describe TODO
* @author hzong
* @datetime 2015-6-15 上午9:50:45 
* @version v1.0   
*/ 
package com.example.android.util.reflection.orm;

import java.lang.reflect.Field;

/** 
 * @className  ORMSQLiteTable 
 * @describe  SQLite表映射創建表語句
 * @author  hzong
 * @datetime  2015-6-15 上午9:50:45  
 */
public class ORMSQLiteTable<T> {
	/** 
	* @fieldName obj
	* @describe 表類
	* @fieldType Class<?>
	*/ 
	private T obj;
	
	
	/** 
	* @fieldName sql_create_table
	* @describe 創建表SQL語句
	* @fieldType StringBuffer
	*/ 
	private StringBuffer sql_create_table;
	
	public ORMSQLiteTable(Class<?> obj){
		try {
			this.obj = (T)obj.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** 
	* @title CreateTable 
	* @describe 拼接創建表語句
	* @return 拼接好的SQL語句
	* @author hzong 
	*/ 
	public String CreateTable(){
		Class<?> obj = this.obj.getClass();
		Field[] field = obj.getFields();
		
		
		sql_create_table.append("create table "+ obj.getSimpleName() +"(");
		sql_create_table.append("id integer primary key autoincrement");
		
		if(field.length == 0){
			throw new IndexOutOfBoundsException("變量為0，請添加變量");
		}
		for(int i = 0; i < field.length;i++){
			sql_create_table.append(","+field[i].getName()+" "+getFieldType(field[i]));
		}
		return sql_create_table.append(")").toString();
	}
	
	
	/** 
	* @title getFieldType 
	* @describe 獲取字段類型字符串
	* @param field 字段封裝類
	* @return SQLite對應數據庫字段
	* @author hzong 
	*/ 
	private String getFieldType(Field field){
		Class<?> type = field.getType();
		if(type.getSimpleName().equals("String") || type.getSimpleName().equals("Array")){
			return "String";
		}else if(type.getSimpleName().equals("Integer") || type.getSimpleName().equals("int")){
			return "integer";
		}else if(type.getSimpleName().equals("double") || type.getSimpleName().equals("float")|| type.getSimpleName().equals("short")){
			return "real";
		}else{
			return "integer";
		}
		
	}
	
	
	
	
	
	
}
