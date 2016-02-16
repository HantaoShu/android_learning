package com.example.contactstest;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity{
	ListView contactsView;
	ArrayAdapter<String> adapter;
	List<String> contactsList = new ArrayList<String>(); 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		contactsView = (ListView) findViewById(R.id.contacts_view);
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,contactsList);
		contactsView.setAdapter(adapter);
		readContacts();

	}
	private void readContacts() {
		// TODO Auto-generated method stub
		Cursor cursor = null;
		try{
			cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
			while(cursor.moveToNext()){
				String displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
				String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
				contactsList.add(displayName+ "\n" + number);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(cursor!= null)
				cursor.close();
		}
	}
}
