package com.example.golflocation;

import java.util.ArrayList;

import com.kayzej.services.GPSTracker;

import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
//import android.view.Window;
//import android.view.WindowManager;
import android.app.Activity;
import android.content.Intent;
//import android.view.Menu;

public class MainActivity extends Activity {

	protected static final int REQUEST_OK = 1;
	
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
		GPSTracker locgps = new GPSTracker(this);
		
		String alat;
		String along;
		
		if(locgps.canGetLocation()){
			double latitude = locgps.getLatitude();
			double longitude = locgps.getLongitude();
			
			alat = String.valueOf(latitude);
			along = String.valueOf(longitude);
			
			Log.i("latitude", alat);
			Log.i("longitude", along);
		}
		else{
			alat = "nope";
			along = "nope";
			locgps.showSettingsAlert();
		}
		
		TextView text = (TextView) findViewById(R.id.label);
		
		setContentView(R.layout.activity_main);
		
		text = (TextView) findViewById(R.id.label);
		text.setText("longitude: " + along + " latitude: " + alat);
	}

	public void SpeechButton(View v){
		Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
        try {
            startActivityForResult(i, REQUEST_OK);
        } catch (Exception e) {
       	 Toast.makeText(this, "Error initializing speech to text engine.", Toast.LENGTH_LONG).show();
        }
	}
	
	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_OK  && resultCode==RESULT_OK) {
        	ArrayList<String> thingsYouSaid = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
        	((TextView)findViewById(R.id.SpeechText)).setText(thingsYouSaid.get(0));
        }
    }
	
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}

}
