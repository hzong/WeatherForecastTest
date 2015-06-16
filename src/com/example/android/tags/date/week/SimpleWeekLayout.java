package com.example.android.tags.date.week;



import com.example.android.util.reflection.ReflectionUtil;
import com.weatherforecasttest.app.R;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @className SimpleWeekLayout
 * @describe 自定义一周标签
 * @author hzong
 * @datetime 2015-6-15 下午9:54:31
 */
public class SimpleWeekLayout extends LinearLayout {

	private int[] week;

	private String color;

	public SimpleWeekLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		LayoutInflater.from(context).inflate(
				R.layout.activity_sys_tag_simple_week, this);

	}

	/**
	 * @title setColor
	 * @describe 设置星期颜色
	 * @param color
	 * @author hzong
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @title setWeek
	 * @describe 设置选中颜色
	 * @param a_i_week
	 *            <p>
	 *            		1-7
	 *            </p>
	 * @author hzong
	 */
	public void setWeek(int[] a_i_week) {
		if (week != a_i_week) {
			for (int val : a_i_week) {
				TextView view = (TextView) findViewById(ReflectionUtil
						.getField(R.id.class, "week_" + val));
				view.getResources().getColor(R.color.gainsboro);
			}
		}

		for (int val : a_i_week) {
			TextView view = (TextView) findViewById(ReflectionUtil.getField(
					R.id.class, "week_" + val));
			view.setTextColor(Color.parseColor(this.color));
		}
	}

}
