package com.example.android.tags.message.chat.main;

import java.util.ArrayList;
import java.util.List;

import com.example.android.base.BaseActivity;
import com.example.android.tags.message.chat.adapter.MsgAdapter;
import com.example.android.tags.message.chat.entity.Msg;
import com.weatherforecasttest.app.R;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends BaseActivity implements OnClickListener {
	 private ListView msgListView;
	 private EditText inputText;
	 private Button send;
	 private MsgAdapter adapter;
	 
	 private List<Msg> msgList = new ArrayList<Msg>();
	 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sys_tag_message_chat_test_main);
        initMesgs();
        adapter = new MsgAdapter(MainActivity.this, R.layout.activity_sys_tag_message_chat_item, msgList);
        inputText =(EditText)findViewById(R.id.input_text);
        send = (Button)findViewById(R.id.send);
        msgListView = (ListView)findViewById(R.id.msg_list_view);
        msgListView.setAdapter(adapter);
        send.setOnClickListener(this);
    }
    void initMesgs(){
    	Msg msg1 = new Msg("Hello guy.",Msg.TYPE_RECEIVED);
    	msgList.add(msg1);
    	Msg msg2 = new Msg("Hello. Who is that ?.",Msg.TYPE_SENT);
    	msgList.add(msg2);
    	Msg msg3 = new Msg("This is Tom. Nice talking to you.",Msg.TYPE_RECEIVED);
    	msgList.add(msg3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
	@Override
	public void onClick(View v) {
		String content = inputText.getText().toString();
		if(!"".equals(content)){
			Msg msg = new Msg(content,Msg.TYPE_RECEIVED);
			msgList.add(msg);
			
			//当有新消息时，刷新ListView中的显示行
			adapter.notifyDataSetChanged();
			
			//将ListView定位到最后一行
			msgListView.setSelection(msgList.size());
			
			inputText.setText("");
		}
		
	}
}
