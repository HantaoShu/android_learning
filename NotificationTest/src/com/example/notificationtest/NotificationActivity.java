package com.example.notificationtest;

import java.io.File;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NotificationActivity extends Activity{
	private Button notice;
	public static final String TAG = "forTest";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		notice = (Button) findViewById(R.id.send_notice);
		notice.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
				NotificationCompat.Builder bd = new NotificationCompat.Builder(NotificationActivity.this);
				bd.setWhen(System.currentTimeMillis());
				bd.setTicker("This is ticker text");
				bd.setSmallIcon(R.drawable.ic_launcher);
				bd.setContentText("This is content text");
				bd.setContentTitle("this is content title");
				Intent intent = new Intent(NotificationActivity.this,ShowActivity.class);
				PendingIntent pi = PendingIntent.getActivity(NotificationActivity.this, 0, intent ,PendingIntent.FLAG_CANCEL_CURRENT);
				bd.setContentIntent(pi);
				Uri uri = Uri.fromFile(new File("system/media/audio/ringtones/Jazz.ogg"));
//				Uri uri = Uri.fromFile(new File("sdcard/kgmusic/download/a.mp3"));
				Log.d(TAG, uri.toString());
				bd.setSound(uri);
				long [] vibrates = {0,1000,1000,1000};
//				bd.setVibrate(vibrates);
				Notification notification= bd.build();
				manager.notify(1,notification);
			
					
			}
		});
	
	}

}
