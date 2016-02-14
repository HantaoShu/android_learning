package com.example.uiwidgettest;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.*;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity{
	private Button button;
	private EditText edittext;
	private ImageView imageView;
	private ProgressBar progressBar;
	private String[] data ={"a","b","c","d","e","f","g","h","i","l"};
	private List<Fruit> fruitList = new ArrayList<Fruit>();
	private IntentFilter intentFilter;
	private NetworkChangeReceiver networkChangeReceiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button = (Button) findViewById(R.id.button);
		/*edittext = (EditText) findViewById(R.id.edit_text);
		imageView = (ImageView) findViewById(R.id.image_view);
		progressBar = (ProgressBar) findViewById(R.id.progress_bar);
		String TAG="MainActivity";
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String text = edittext.getText().toString();
//				Toast.makeText(MainActivity.this,text, Toast.LENGTH_LONG).show();
//				imageView.setImageResource(R.drawable.j);
//				if(progressBar.getVisibility()==View.GONE) progressBar.setVisibility(View.VISIBLE);
//				else progressBar.setVisibility(View.GONE);
//				progressBar.setProgress(progressBar.getProgress()+10);
				AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
				dialog.setTitle("this is dialog");
				dialog.setMessage("sth important.");
				dialog.setCancelable(false);
				dialog.setPositiveButton("OK",new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
					}
				});
				dialog.setNegativeButton("cancel",new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
					}
				});
				dialog.show();

				ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
				progressDialog.setTitle("this is Progress Dialog");
				progressDialog.setMessage("Loading...");
				progressDialog.setCancelable(true);
				progressDialog.show();
			}
		});
		initFruit();
		FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit_image,fruitList);
		ListView listview = (ListView) findViewById(R.id.list_view);
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				Fruit fruit = fruitList.get(position);
				Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_LONG).show();
			}
		});
		float xdpi = getResources().getDisplayMetrics().xdpi;
		float ydpi = getResources().getDisplayMetrics().ydpi;
		Log.d(TAG, "xdpi"+xdpi+"ydpi"+ydpi);
		intentFilter = new IntentFilter();
		intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
		networkChangeReceiver = new NetworkChangeReceiver();
		registerReceiver(networkChangeReceiver, intentFilter);
		*/
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent("com.example.broadcasttest.MY_BROADCAST");
				sendBroadcast(intent);
			}
		});
	}
	private void initFruit(){
		for (int i=0;i<data.length;i++){
			Fruit tem = new Fruit(data[i],R.drawable.ic_launcher);
			fruitList.add(tem);
		}
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		unregisterReceiver(networkChangeReceiver);
	}
	class NetworkChangeReceiver extends BroadcastReceiver{
		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			ConnectivityManager connectionManger = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo networkInfo = connectionManger.getActiveNetworkInfo();
			if (networkInfo!=null && networkInfo.isAvailable())  
				Toast.makeText(context,"network is available", Toast.LENGTH_LONG).show();
			else 
				Toast.makeText(context,"network is not available", Toast.LENGTH_LONG).show();
		}
	}
}