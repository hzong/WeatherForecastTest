/**   
* @title Msg.java 
* @package com.example.android.tags.message.chat.entity 
* @describe TODO
* @author hzong
* @datetime 2015-5-19 下午9:49:19 
* @version v1.0   
*/ 
package com.example.android.tags.message.chat.entity;

/** 
 * @className  Msg 
 * @describe  消息实体类
 * @author  hzong
 * @datetime  2015-5-19 下午9:49:19  
 */
public class Msg {
	
	
	/** 
	* title UIBestPractice
	* describe 私有构造 
	*/ 
	private Msg() {
		super();
	}
	/** 
	* title UIBestPractice
	* describe TODO
	* @param content 内容
	* @param type  消息类型
	*/ 
	public Msg(String content, int type) {
		super();
		this.content = content;
		this.type = type;
	}
	/** 
	* @fieldName TYPE_RECEIVED
	* @describe 表示这是一条收到的消息
	* @fieldType int
	*/ 
	public static final int TYPE_RECEIVED=0;
	/** 
	* @fieldName TYPE_SENT
	* @describe 表示这是一条发出消息
	* @fieldType int
	*/ 
	public static final int TYPE_SENT=1;
	/** 
	* @fieldName content
	* @describe 内容
	* @fieldType String
	*/ 
	private String content;
	/** 
	* @fieldName type
	* @describe 消息类型
	* @fieldType int
	*/ 
	private int type;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
	
}
