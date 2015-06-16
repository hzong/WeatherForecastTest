/**
 * 
 */
package com.example.android.base;



import com.example.android.manager.activity.ActivityCollector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

/**
 * @className BaseActivity
 * @describe 所有的活动超类
 * @author hzong
 * @datetime 2015-5-14 下午8:37:58
 */
public class BaseActivity extends Activity {
	private final String tag = "BaseActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		Log.d(tag, this.getClass().getName());
		ActivityCollector.addActivity(this);
	}

	@Override
	public void startActivityForResult(Intent intent, int requestCode) {
		// TODO Auto-generated method stub
		super.startActivityForResult(intent, requestCode);
	}

	@Override
	protected void onDestroy() {
		ActivityCollector.removeActivity(this);
		super.onDestroy();
	}
}
