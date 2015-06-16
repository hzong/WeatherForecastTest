/**   
* @title TitleLayout.java 
* @package com.example.uicustom.app.tags.title 
* @describe TODO
* @author hzong
* @datetime 2015-5-14 下午8:56:11 
* @version v1.0   
*/ 
package com.example.android.tags.title;







import com.weatherforecasttest.app.R;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.view.View.OnClickListener;

/** 
 * @className  TitleLayout 
 * @describe  TODO
 * @author  hzong
 * @datetime  2015-5-14 下午8:56:11  
 */
public class TitleLayout extends LinearLayout implements OnClickListener {

	public TitleLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		//inflate方法可以动态加载一个布局文件
		LayoutInflater.from(context).inflate(R.layout.activity_sys_tag_title, this);
		Button title_edit = (Button)findViewById(R.id.title_edit);
		Button title_back = (Button)findViewById(R.id.title_back);
		title_edit.setOnClickListener(this);
		title_back.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.title_back:
			((Activity)getContext()).finish();
			break;

		default:
			Toast.makeText(getContext(), "你点击是EDIT BUTTON", Toast.LENGTH_SHORT).show();
			break;
		}
	}

}
