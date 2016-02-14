package com.example.filepersistencetest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity{
	private EditText edit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edit = (EditText) findViewById(R.id.editText1);
		String input = load();
		if(!TextUtils.isEmpty(input)){
			edit.setText(input);
			edit.setSelection(input.length());
			Toast.makeText(this, "succeed", Toast.LENGTH_LONG).show();
		}
		
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		String inputText = edit.getText().toString();
		save(inputText);
	}
	public void save(String input){
		FileOutputStream out = null;
		BufferedWriter writer = null;
		try{
			out = openFileOutput("data.dat", Context.MODE_PRIVATE);
			writer = new BufferedWriter(new OutputStreamWriter(out));
			writer.write(input);
		} catch(IOException e){
			e.printStackTrace();
		} finally {
			try{
				if(writer != null)
					writer.close();
			} catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	public String load(){
		FileInputStream in = null;
		BufferedReader reader = null;
		StringBuffer content = new StringBuffer();
		try{
			in = openFileInput("data.dat");
			reader = new BufferedReader(new InputStreamReader(in));
			String line = "";
			while((line = reader.readLine())!=null){
				content.append(line);
			}
		} catch(IOException e){
			e.printStackTrace();
		} finally{
			if(reader!=null) {
				try{
					reader.close();
				} catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		return content.toString();
	}
}

