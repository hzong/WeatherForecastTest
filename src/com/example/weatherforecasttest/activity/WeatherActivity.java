package com.example.weatherforecasttest.activity;

//import net.youmi.android.banner.AdSize;
//import net.youmi.android.banner.AdView;
import com.example.android.tags.button.combined.ButtonCombinedLayout;
import com.example.android.tags.dialog.menu.CustomMenuDialog;
import com.example.android.util.DateTimeUtil;
import com.example.android.util.HttpCallbackListener;
import com.example.android.util.HttpUtil;
import com.example.android.util.Utility;
import com.example.weatherforecasttest.service.AutoUpdateService;
import com.example.weatherforecasttest.service.ClockService;
import com.weatherforecasttest.app.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;


public class WeatherActivity extends Activity implements OnClickListener{

	private LinearLayout weatherInfoLayout;
	/**
	 * 用于显示城市名
	 */
	private TextView cityNameText;
	
	/** 
	* @fieldName set_clock
	* @describe  设置闹钟
	* @fieldType Button
	*/ 
	private Button set_clock;
	
	/**
	 * 用于显示发布时间
	 */
	private TextView publishText;
	/**
	 * 用于显示天气描述信息
	 */
	private TextView weatherDespText;
	/**
	 * 用于显示气温1
	 */
	private TextView temp1Text;
	/**
	 * 用于显示气温2
	 */
	private TextView temp2Text;
	/**
	 * 用于显示当前日期
	 */
	private TextView currentDateText;
	/**
	 * 切换城市按钮
	 */
	private Button switchCity;
	/**
	 * 更新天气按钮
	 */
	private Button refreshWeather;
	
	private TimePicker timePicker;
	
	Dialog dialog1;
	 ButtonCombinedLayout save_ccancel;
	
	@SuppressLint("NewApi") @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.weather_layout);
		
		 dialog1= new Dialog(this);  
			
	        dialog1.setContentView(R.layout.set_clock);  
	        dialog1.setTitle("设置时间");  
	        timePicker = (TimePicker)dialog1.findViewById(R.id.tp_time);
			timePicker.setIs24HourView(true);
	        
	        
	         save_ccancel = (ButtonCombinedLayout)dialog1.findViewById(R.id.save_ccancel);
	        SharedPreferences sharedPreferences  = PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this);
	        if(sharedPreferences.getString("time_hour", null) != null){
	        	timePicker.setCurrentHour(Integer.parseInt(sharedPreferences.getString("time_hour", "0")));
	        	timePicker.setCurrentMinute(Integer.parseInt(sharedPreferences.getString("time_minute","0")));
	        	Intent i = new Intent(WeatherActivity.this,ClockService.class);
				stopService(i);
				 i = new Intent(WeatherActivity.this,ClockService.class);
				startService(i);
			}
		 
		 
		 
		// 初始化各控件
		set_clock = (Button) findViewById(R.id.set_clock);
		set_clock.setOnClickListener(this);
		
		
		weatherInfoLayout = (LinearLayout) findViewById(R.id.weather_info_layout);
		cityNameText = (TextView) findViewById(R.id.city_name);
		publishText = (TextView) findViewById(R.id.publish_text);
		weatherDespText = (TextView) findViewById(R.id.weather_desp);
		temp1Text = (TextView) findViewById(R.id.temp1);
		temp2Text = (TextView) findViewById(R.id.temp2);
		currentDateText = (TextView) findViewById(R.id.current_date);
		switchCity = (Button) findViewById(R.id.switch_city);
		refreshWeather = (Button) findViewById(R.id.refresh_weather);
		String countyCode = getIntent().getStringExtra("county_code");
		if (!TextUtils.isEmpty(countyCode)) {
			// 有县级代号时就去查询天气
			publishText.setText("同步中...");
			weatherInfoLayout.setVisibility(View.INVISIBLE);
			cityNameText.setVisibility(View.INVISIBLE);
			queryWeatherCode(countyCode);
		} else {
			// 没有县级代号时就直接显示本地天气
			showWeather();
		}
		switchCity.setOnClickListener(this);
		refreshWeather.setOnClickListener(this);
		//实例化广告条
//	    AdView adView = new AdView(this, AdSize.FIT_SCREEN);
	    //获取要嵌入广告条的布局
//	    LinearLayout adLayout=(LinearLayout)findViewById(R.id.adLayout);
	    //将广告条加入到布局中
//	    adLayout.addView(adView);
		
		
		
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.switch_city:
			Intent intent = new Intent(this, ChooseAreaActivity.class);
			intent.putExtra("from_weather_activity", true);
			startActivity(intent);
			finish();
			break;
		case R.id.set_clock:
		
	        
	        
	        save_ccancel.setButtonCombined1("存储", new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					SharedPreferences sharedPreferences  = PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this);
					Editor editor =  sharedPreferences.edit();
//					if(sharedPreferences.getString("time_hour", null) == null){
						editor.putString("time_hour", DateTimeUtil.getNumberTimeFormat(timePicker.getCurrentHour()));
						editor.putString("time_minute", DateTimeUtil.getNumberTimeFormat(timePicker.getCurrentMinute()));
						editor.commit();
//					}
						Intent i = new Intent(WeatherActivity.this,ClockService.class);
						stopService(i);
						 i = new Intent(WeatherActivity.this,ClockService.class);
						startService(i);
						
					dialog1.dismiss();
				}
			});
	        save_ccancel.setButtonCombined2("取消", new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					dialog1.dismiss();
				}
			});
	        
	        dialog1.show();  
			break;
		case R.id.refresh_weather:
			publishText.setText("同步中...");
			SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
			String weatherCode = prefs.getString("weather_code", "");
			if (!TextUtils.isEmpty(weatherCode)) {
				queryWeatherInfo(weatherCode);
			}
			break;
		default:
			break;
		}
	}
	
	/**
	 * 查询县级代号所对应的天气代号。
	 */
	private void queryWeatherCode(String countyCode) {
		String address = "http://www.weather.com.cn/data/list3/city" + countyCode + ".xml";
		queryFromServer(address, "countyCode");
	}

	/**
	 * 查询天气代号所对应的天气。
	 */
	private void queryWeatherInfo(String weatherCode) {
		String address = "http://www.weather.com.cn/data/cityinfo/" + weatherCode + ".html";
		queryFromServer(address, "weatherCode");
	}
	
	/**
	 * 根据传入的地址和类型去向服务器查询天气代号或者天气信息。
	 */
	private void queryFromServer(final String address, final String type) {
		HttpUtil.sendHttpRequest(address, new HttpCallbackListener() {
			@Override
			public void onFinish(final String response) {
				if ("countyCode".equals(type)) {
					if (!TextUtils.isEmpty(response)) {
						// 从服务器返回的数据中解析出天气代号
						String[] array = response.split("\\|");
						if (array != null && array.length == 2) {
							String weatherCode = array[1];
							queryWeatherInfo(weatherCode);
						}
					}
				} else if ("weatherCode".equals(type)) {
					// 处理服务器返回的天气信息
					Utility.handleWeatherResponse(WeatherActivity.this, response);
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							showWeather();
						}
					});
				}
			}
			
			@Override
			public void onError(Exception e) {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						publishText.setText("同步失败");
					}
				});
			}
		});
	}
	
	/**
	 * 从SharedPreferences文件中读取存储的天气信息，并显示到界面上。
	 */
	private void showWeather() {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		cityNameText.setText( prefs.getString("city_name", ""));
		temp1Text.setText(prefs.getString("temp1", ""));
		temp2Text.setText(prefs.getString("temp2", ""));
		weatherDespText.setText(prefs.getString("weather_desp", ""));
		publishText.setText("今天" + prefs.getString("publish_time", "") + "发布");
		currentDateText.setText(prefs.getString("current_date", ""));
		weatherInfoLayout.setVisibility(View.VISIBLE);
		cityNameText.setVisibility(View.VISIBLE);
		Intent intent = new Intent(this, AutoUpdateService.class);
		startService(intent);
	}

}