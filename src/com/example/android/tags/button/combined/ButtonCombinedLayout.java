package com.example.android.tags.button.combined;


import com.weatherforecasttest.app.R;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/** 
* @className  ButtonCombinedLayout 
* @describe  组合按钮
* @author  hzong
* @datetime  2015-6-15 下午11:05:09  
*/ 
public class ButtonCombinedLayout extends LinearLayout {

	
	public ButtonCombinedLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		LayoutInflater.from(context).inflate(
				R.layout.activity_sys_tag_button_combined, this);
	}
	
	/** 
	* @title setButtonCombined1 
	* @describe 设置按钮1
	* @param name 名称
	* @param clickListener 单击事件
	* @return 返回设置过的按钮
	* @author hzong 
	*/ 
	public Button setButtonCombined1(String name,OnClickListener clickListener){
		return setButtonCombined(R.id.but_com_1, name, clickListener);
	}
	/** 
	* @title setButtonCombined2 
	* @describe 设置按钮2
	* @param name 名称
	* @param clickListener 单击事件
	* @return 返回设置过的按钮
	* @author hzong 
	*/ 
	public Button setButtonCombined2(String name,OnClickListener clickListener){
		return setButtonCombined(R.id.but_com_2, name, clickListener);
	}
	
	
	/** 
	* @title setButtonCombined2 
	* @describe 设置按钮2
	* @param id 设置 id
	* @param name 名称
	* @param clickListener 单击事件
	* @return 返回设置过的按钮
	* @author hzong 
	*/ 
	private Button setButtonCombined(int id,String name,OnClickListener clickListener){
		Button but =  (Button)findViewById(id);
		but.setText(name);
		if(clickListener != null){
			but.setOnClickListener(clickListener);
		}else{
			but.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					((Activity)getContext()).finish();
				}
			});
		}
		return but;
	}
	
	
}
