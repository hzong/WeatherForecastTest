/**   
 * @title ClockService.java 
 * @package com.example.weatherforecasttest.service 
 * @describe TODO
 * @author hzong
 * @datetime 2015-6-17 上午11:53:33 
 * @version v1.0   
 */
package com.example.weatherforecasttest.service;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.baidu.speechsynthesizer.SpeechSynthesizer;
import com.baidu.speechsynthesizer.SpeechSynthesizerListener;
import com.baidu.speechsynthesizer.publicutility.SpeechError;
import com.example.android.util.DateTimeUtil;
import com.example.android.util.HttpCallbackListener;
import com.example.android.util.HttpUtil;
import com.example.android.util.Utility;
import com.example.weatherforecasttest.activity.WeatherActivity;
import com.example.weatherforecasttest.receiver.ClockReceiver;
import com.weatherforecasttest.app.R;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources.NotFoundException;
import android.os.Environment;
import android.os.IBinder;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.speech.SpeechRecognizer;
import android.text.TextUtils;

/**
 * @className ClockService
 * @describe 闹钟
 * @author hzong
 * @datetime 2015-6-17 上午11:53:33
 */
public class ClockService extends Service implements SpeechSynthesizerListener {
	SpeechSynthesizer synthesizer;
	/** 指定license路径，需要保证该路径的可读写权限 */
	private static final String LICENCE_FILE_NAME = Environment
			.getExternalStorageDirectory() + "/tts/baidu_tts_licence.dat";

	/**
	 * @title onBind
	 * @describe TODO
	 * @param intent
	 * @return
	 * @overridden @see android.app.Service#onBind(android.content.Intent)
	 * @author hzong
	 */

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int onStartCommand(final Intent intent, int flags, int startId) {

		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				String message = "在那六的拉萨东方";//intent.getStringExtra("message");
				int day = DateTimeUtil.getWeekDayNumber(new Date());
				if (day == 6 || day == 7) {
					Notification notification = new Notification(
							R.drawable.ic_launcher, message,
							System.currentTimeMillis());
					notification.setLatestEventInfo(ClockService.this, "天气预报",
							message, null);
				} else {
					synthesizer.speak(message);
				}

			}
		}).start();
//		timePicker.setCurrentHour(Integer.parseInt(sharedPreferences.getString("time_hour", "0")));
//    	timePicker.setCurrentMinute(Integer.parseInt(sharedPreferences.getString("time_minute","0")));
		AlarmManager manager = (AlarmManager)getSystemService(ALARM_SERVICE);
		int anhour =1*60*1000;
		long triggerAtTime = SystemClock.elapsedRealtime()+anhour;
		Intent i = new Intent(this, ClockReceiver.class);
		PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, 0);
		manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggerAtTime, pi);
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onCreate() {
		synthesizer = SpeechSynthesizer.newInstance(
				SpeechSynthesizer.SYNTHESIZER_AUTO, getApplicationContext(),
				"hz", ClockService.this);
		synthesizer.setApiKey("POgUor7VBfufi6FQ6xYUbxxG",
				"RB5VwczFTDf3fygcSGPXuC9BAzWOCufV");
		// 设置授权文件路径
		synthesizer.setParam(SpeechSynthesizer.PARAM_TTS_LICENCE_FILE,
				LICENCE_FILE_NAME);
		// TTS所需的资源文件，可以放在任意可读目录，可以任意改名
		String ttsTextModelFilePath = getApplicationContext()
				.getApplicationInfo().dataDir + "/lib/libbd_etts_text.dat.so";
		
		
	}

	@Override
	public void onBufferProgressChanged(SpeechSynthesizer arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCancel(SpeechSynthesizer arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onError(SpeechSynthesizer arg0, SpeechError arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onNewDataArrive(SpeechSynthesizer arg0, byte[] arg1,
			boolean arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSpeechFinish(SpeechSynthesizer arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSpeechPause(SpeechSynthesizer arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSpeechProgressChanged(SpeechSynthesizer arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSpeechResume(SpeechSynthesizer arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSpeechStart(SpeechSynthesizer arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStartWorking(SpeechSynthesizer arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSynthesizeFinish(SpeechSynthesizer arg0) {
		// TODO Auto-generated method stub

	}

}
