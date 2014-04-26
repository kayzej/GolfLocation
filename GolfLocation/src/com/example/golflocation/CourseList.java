package com.example.golflocation;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CourseList extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.course_list);

		ListView menuList = (ListView) findViewById(R.id.ListView_Menu);
		ArrayList<String> items = new ArrayList<String>();
		items.add("Black Oak");
		
		ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, R.layout.menu_item, items);
		menuList.setAdapter(adapt);
		
		menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

	         public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {

	             // Note: if the list was built "by hand" the id could be used.
	             // As-is, though, each item has the same id

	             //TextView textView = (TextView) itemClicked;
	             //String strText = textView.getText().toString();
	             
	             
	         }
	     });
	}
}
