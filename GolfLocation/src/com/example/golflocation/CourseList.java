package com.example.golflocation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class CourseList extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.course_list);
	
		ListView menuList = (ListView) findViewById(R.id.ListView_Menu);

	    String[] items = { getResources().getString(R.string.menu_course1),
	             getResources().getString(R.string.menu_course2),
	             getResources().getString(R.string.menu_course3),
	             getResources().getString(R.string.menu_course4)};
	    ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, R.layout.menu_item, items);
	    menuList.setAdapter(adapt);
	    
	    menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

	         public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
	
	             // Note: if the list was built "by hand" the id could be used.
	             // As-is, though, each item has the same id
	
	             TextView textView = (TextView) itemClicked;
	             String strText = textView.getText().toString();
	
	             if (strText.equalsIgnoreCase(getResources().getString(R.string.menu_course1))) {
	                 // Launch the Game Activity
	                 startActivity(new Intent(CourseList.this, Course1.class));
	             } else if (strText.equalsIgnoreCase(getResources().getString(R.string.menu_course2))) {
	                 // Launch the Help Activity
	                 startActivity(new Intent(CourseList.this, Course2.class));
	             } else if (strText.equalsIgnoreCase(getResources().getString(R.string.menu_course3))) {
	                 // Launch the Settings Activity
	                 startActivity(new Intent(CourseList.this, Course3.class));
	             } else if (strText.equalsIgnoreCase(getResources().getString(R.string.menu_course4))) {
	                 // Launch the Scores Activity
	                 startActivity(new Intent(CourseList.this, Course4.class));
	             }
	
	         }
	     });
	}
}
