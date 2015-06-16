/**   
 * @title ImageTextAdapter.java 
 * @package com.example.android.tags.listview 
 * @describe 預報適配器
 * @author hzong
 * @datetime 2015-5-18 下午8:53:38 
 * @version v1.0   
 */
package com.example.android.tags.listview.adapter;

import java.util.List;

import com.example.android.tags.date.week.SimpleWeekLayout;
import com.example.android.tags.listview.entity.Forecast;
import com.weatherforecasttest.app.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @className ImageTextAdapter
 * @describe 图片文本适配器
 * @author hzong
 * @datetime 2015-5-18 下午8:53:38
 */
public class ForecastListAdapter extends ArrayAdapter<Forecast> {

	private int resourceId;
	private ViewGroup view;
	private Forecast forecast;
	private ViewHolder holder;
	private Activity activity;
	
	public ForecastListAdapter(Context context, int textViewResourceId,
			List<Forecast> objects) {
		super(context, textViewResourceId, objects);
		this.activity = (Activity) context;
		resourceId = textViewResourceId;
	}

	/**
	 * @title getView
	 * @describe 每个子项被滚动到屏幕内的时候会调用
	 * @param position
	 * @param convertView
	 * @param parent
	 * @return
	 * @overridden @see android.widget.ArrayAdapter#getView(int,
	 *             android.view.View, android.view.ViewGroup)
	 * @author hzong
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		 forecast = getItem(position);
		/**
		 * 判断重复加载布局如果convertView为空，则使用LayoutInflater去加载布局，如果不为空直接对convertView重用，
		 * 这样就提升了 ListView运行效率
		 * 
		 */
		if (convertView == null) {
			view = (ViewGroup) LayoutInflater.from(getContext()).inflate(
					resourceId, null);
			
			LinearLayout ll =  (LinearLayout)view.findViewById(R.id.ll_content);
			ll.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
//					ForecastAddActivity.actionStart(activity);
				}
			});
			
			holder = new ViewHolder();
			holder.getIs_use().setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					int tag = Integer.parseInt(v.getTag().toString());
					v.setBackgroundResource(0);
					if(tag == 0){
						v.setBackgroundResource(R.drawable.iconfont_forecast_show);
						v.setTag(1);
					}else{
						v.setBackgroundResource(R.drawable.iconfont_forecast);
						v.setTag(0);
					}
				}
			});
			view.setTag(holder);
		} else {
			view = (ViewGroup) convertView;
			holder = (ViewHolder) view.getTag();
		}

		holder.forecast_name.setText(forecast.getForecast_name());
		holder.forecast_time.setText(forecast.getForecast_time());
		holder.setWeek(forecast.getWeek());
		holder.setIs_use(forecast.isIs_use());
		
		
		return view;
	}

	/**
	 * @className ViewHolder
	 * @describe 对于控件实例进行缓存
	 * @author hzong
	 * @datetime 2015-5-18 下午9:58:44
	 */
	class ViewHolder {
		/**
		 * @fieldName tv_name
		 * @describe 名称
		 * @fieldType TextView
		 */
		private TextView forecast_name = (TextView)view.findViewById(R.id.forecast_name);
		/**
		 * @fieldName tv_time
		 * @describe 时间
		 * @fieldType TextView
		 */
		private TextView forecast_time = (TextView)view.findViewById(R.id.forecast_time);
		/**
		 * @fieldName week
		 * @describe 一周
		 * @fieldType TextView[]
		 */
		private SimpleWeekLayout week;
		/**
		 * @fieldName is_use
		 * @describe 是否使用
		 * @fieldType ImageView
		 */
		private ImageView is_use =(ImageButton)view.findViewById(R.id.is_use);

		public TextView getForecast_name() {
			return forecast_name;
		}

		public void setForecast_name(String forecast_name) {

			this.forecast_name.setText(forecast_name);
			;
		}

		public TextView getForecast_time() {
			return forecast_time;
		}

		public void setForecast_time(String forecast_time) {
			this.forecast_time.setText(forecast_time);
		}

		public SimpleWeekLayout getWeek() {
			return week;
		}

		public void setWeek(int[] week) {
			if(week == null)
				return;
			this.week.setColor("#8c9eff");
			this.week.setWeek(week);
			
		}

		public ImageView getIs_use() {
			return is_use;
		}

		public void setIs_use(boolean is_use) {
			int img = R.drawable.iconfont_forecast;
			if (is_use) {
				img = R.drawable.iconfont_forecast_show;
				this.is_use.setTag(1);
			}
			
			this.is_use.setBackgroundResource(img);
		}
		
	}

}
