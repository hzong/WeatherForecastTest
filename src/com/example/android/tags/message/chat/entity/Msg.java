/**   
* @title Msg.java 
* @package com.example.android.tags.message.chat.entity 
* @describe TODO
* @author hzong
* @datetime 2015-5-19 ����9:49:19 
* @version v1.0   
*/ 
package com.example.android.tags.message.chat.entity;

/** 
 * @className  Msg 
 * @describe  ��Ϣʵ����
 * @author  hzong
 * @datetime  2015-5-19 ����9:49:19  
 */
public class Msg {
	
	
	/** 
	* title UIBestPractice
	* describe ˽�й��� 
	*/ 
	private Msg() {
		super();
	}
	/** 
	* title UIBestPractice
	* describe TODO
	* @param content ����
	* @param type  ��Ϣ����
	*/ 
	public Msg(String content, int type) {
		super();
		this.content = content;
		this.type = type;
	}
	/** 
	* @fieldName TYPE_RECEIVED
	* @describe ��ʾ����һ���յ�����Ϣ
	* @fieldType int
	*/ 
	public static final int TYPE_RECEIVED=0;
	/** 
	* @fieldName TYPE_SENT
	* @describe ��ʾ����һ��������Ϣ
	* @fieldType int
	*/ 
	public static final int TYPE_SENT=1;
	/** 
	* @fieldName content
	* @describe ����
	* @fieldType String
	*/ 
	private String content;
	/** 
	* @fieldName type
	* @describe ��Ϣ����
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
