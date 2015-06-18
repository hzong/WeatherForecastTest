/**
 * 
 */
package com.example.android.tags.dialog.menu;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

/**
 * 
 * 自定义菜单对话框
 * 
 * @author hzong
 * 
 */
public class CustomMenuDialog extends AlertDialog {
	private int layout;

	public CustomMenuDialog(Context context, int theme, int layout) {
		super(context, theme);
		// TODO Auto-generated constructor stub
		this.layout = layout;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(layout);
	}
}
