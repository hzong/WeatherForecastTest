package com.example.android.util;

public interface HttpCallbackListener {

	void onFinish(String response);

	void onError(Exception e);

}
