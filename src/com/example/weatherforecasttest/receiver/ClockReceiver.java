/**   
* @title ClockReceiver.java 
* @package com.example.weatherforecasttest.receiver 
* @describe TODO
* @author hzong
* @datetime 2015-6-17 ÏÂÎç4:39:19 
* @version v1.0   
*/ 
package com.example.weatherforecasttest.receiver;

import com.example.weatherforecasttest.service.ClockService;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/** 
 * @className  ClockReceiver 
 * @describe  ÄÖÖÓ½»»¥
 * @author  hzong
 * @datetime  2015-6-17 ÏÂÎç4:39:19  
 */
public class ClockReceiver extends BroadcastReceiver {

	/** 
	 * @title onReceive 
	 * @describe TODO
	 * @param context
	 * @param intent 
	 * @overridden @see android.content.BroadcastReceiver#onReceive(android.content.Context, android.content.Intent) 
	 * @author hzong 
	 */

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Intent i = new Intent(context,ClockService.class);
		context.startService(intent);
	}

}
