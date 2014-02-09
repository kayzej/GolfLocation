package com.example.golflocation;

import java.util.ArrayList;
import java.util.Locale;

import com.kayzej.services.GPSTracker;

import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
//import android.view.Window;
//import android.view.WindowManager;
import android.app.Activity;
import android.content.Intent;
//import android.view.Menu;

public class MainActivity extends Activity implements OnInitListener {
//public class MainActivity extends Activity{
	protected static final int REQUEST_OK = 1;
	
	private TextToSpeech tts;
	
	private GPSTracker gps;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //WindowManager.LayoutParams.FLAG_FULLSCREEN)
		tts = new TextToSpeech(this, this);
		gps = new GPSTracker(this);
		setContentView(R.layout.activity_main);
		
		//View v = this.getCurrentFocus();
		
		//GPSRefresh(v);
	}
	
	public void ListView(View view){
		//Open the ListView
		startActivity(new Intent(MainActivity.this,CourseList.class));
	}
	
	public void GPSRefresh(View view){
	
		String alat;
		String along;
		gps.getLocation();
		
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

	@Override
	public void onInit(int code) {
		if (code==TextToSpeech.SUCCESS) {
			tts.setLanguage(Locale.getDefault());
		} else {
			tts = null;
			Toast.makeText(this, "Failed to initialize TTS engine.", Toast.LENGTH_SHORT).show();
		}
	}
	
	public void TTSTouch(View v){
		if (tts!=null) {
			String text = ((EditText)findViewById(R.id.SayThis)).getText().toString();
			if (text!=null) {
				if (!tts.isSpeaking()) {
					tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
				}
			}
		}
	}
	
	@Override
	protected void onDestroy() {
		if (tts!=null) {
			tts.stop();
            tts.shutdown();
		}
		super.onDestroy();
	}
	
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}

}
