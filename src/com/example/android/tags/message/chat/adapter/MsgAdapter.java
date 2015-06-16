/**   
* @title MsgAdapter.java 
* @package com.example.android.tags.message.chat.adapter 
* @describe TODO
* @author hzong
* @datetime 2015-5-19 下午10:05:24 
* @version v1.0   
*/ 
package com.example.android.tags.message.chat.adapter;

import java.util.List;

import com.example.android.tags.message.chat.entity.Msg;
import com.weatherforecasttest.app.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

/** 
 * @className  MsgAdapter 
 * @describe  TODO
 * @author  hzong
 * @datetime  2015-5-19 下午10:05:24  
 */
public class MsgAdapter extends ArrayAdapter<Msg> {
	private int resourceId;
	public MsgAdapter(Context context, int textViewResourceId, List<Msg> objects) {
		super(context, textViewResourceId, objects);
		this.resourceId = textViewResourceId;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Msg msg = getItem(position);
		View view;
		ViewHolder viewHolder;
		if(convertView == null){
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.leftLayout=(LinearLayout)view.findViewById(R.id.left_layout);
			viewHolder.rightLayout=(LinearLayout)view.findViewById(R.id.right_layout);
			viewHolder.leftMsg=(TextView)view.findViewById(R.id.left_msg);
			viewHolder.rightMsg=(TextView)view.findViewById(R.id.right_msg);
			view.setTag(viewHolder);
		}else{
			view = convertView;
			viewHolder = (ViewHolder)view.getTag();
		}
		
		if(msg.getType() == Msg.TYPE_RECEIVED){
			//如果收到消息，则显示左边的消息布局，将右边的消息布局隐藏
			viewHolder.leftLayout.setVisibility(View.VISIBLE);
			viewHolder.leftMsg.setText(msg.getContent());
			viewHolder.rightLayout.setVisibility(View.GONE);
		}else{
			//如果发出消息，则显示右边的消息布局，将左边的消息布局隐藏
			viewHolder.leftLayout.setVisibility(View.GONE);
			viewHolder.rightMsg.setText(msg.getContent());
			viewHolder.rightLayout.setVisibility(View.VISIBLE);
		}
		return view;
	}
	
	class ViewHolder{
		/** 
		* @fieldName leftLayout
		* @describe 发送布局
		* @fieldType LinearLayout
		*/ 
		LinearLayout leftLayout;
		/** 
		* @fieldName rightLayout
		* @describe 接收布局
		* @fieldType LinearLayout
		*/ 
		LinearLayout rightLayout;
		/** 
		* @fieldName leftMsg
		* @describe 做消息
		* @fieldType TextView
		*/ 
		TextView leftMsg;
		/** 
		* @fieldName rightMsg
		* @describe 右消息
		* @fieldType TextView
		*/ 
		TextView rightMsg;
		
	}

}
