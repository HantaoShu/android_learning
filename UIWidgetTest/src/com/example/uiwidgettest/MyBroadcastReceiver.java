package com.example.uiwidgettest;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BootCompleteReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Toast.makeText(context, "received in MyBroadcastReceiver", Toast.LENGTH_LONG).show();
	}
}
