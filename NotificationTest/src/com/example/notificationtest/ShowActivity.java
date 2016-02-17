package com.example.notificationtest;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;

public class ShowActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show);
		NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		manager.cancel(1);
	}
}
