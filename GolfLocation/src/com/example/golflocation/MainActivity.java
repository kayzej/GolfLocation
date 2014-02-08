package com.example.golflocation;

import com.kayzej.services.GPSTracker;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
//import android.view.Window;
//import android.view.WindowManager;
import android.app.Activity;
import android.content.Intent;
//import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //WindowManager.LayoutParams.FLAG_FULLSCREEN)
		
		GPSTracker gps = new GPSTracker(this);
		
		String alat;
		String along;
		
		if(gps.canGetLocation()){
			double latitude = gps.getLatitude();
			double longitude = gps.getLongitude();
			
			alat = String.valueOf(latitude);
			along = String.valueOf(longitude);
			
			Log.i("latitude", alat);
			Log.i("longitude", along);
		}
		else{
			alat = "nope";
			along = "nope";
			gps.showSettingsAlert();
		}
		
		TextView text = (TextView) findViewById(R.id.label);
		
		setContentView(R.layout.activity_main);
		
		text = (TextView) findViewById(R.id.label);
		text.setText("longitude: " + along + " latitude: " + alat);
	}
	
	public void ListView(View view){
		//Open the ListView
		startActivity(new Intent(MainActivity.this,CourseList.class));
	}
	
	public void GPSRefresh(View view){
		//double latitude = gps.getLatitude();
		//double longitude = gps.getLongitude();
		Log.i("GPSREFRESH, ", "Button is doing step 1");
GPSTracker gps = new GPSTracker(this);
		
		String alat;
		String along;
		
		if(gps.canGetLocation()){
			double latitude = gps.getLatitude();
			double longitude = gps.getLongitude();
			
			alat = String.valueOf(latitude);
			along = String.valueOf(longitude);
			
			Log.i("latitude", alat);
			Log.i("longitude", along);
		}
		else{
			alat = "nope";
			along = "nope";
			gps.showSettingsAlert();
		}
		
		TextView text = (TextView) findViewById(R.id.label);
		
		setContentView(R.layout.activity_main);
		
		text = (TextView) findViewById(R.id.label);
		text.setText("longitude: " + along + " latitude: " + alat);
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}

}
