package com.mftech.mindmap;

import com.mftech.mindmap.settingsactivites.MainPreferanceActivity;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {
	public static final int result_settings=1;
	private TextView text;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.activity_main);
		text = (TextView)findViewById(R.id.main_textview);
		Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/ExpletiveDeleted.ttf");
		text.setTypeface(tf);
		AssetManager assetManager = getAssets();
		text.setText("Pls take this gift from My heart to you.");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	 @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        switch (item.getItemId()) {
	        case R.id.menu_settings:
	            Intent i = new Intent(this, MainPreferanceActivity.class);
	            startActivityForResult(i, result_settings);
	            break;
	 
	        }
	 
	        return true;
	    }
	 
	    @Override
	    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	        super.onActivityResult(requestCode, resultCode, data);
	        switch(requestCode){
	        	case result_settings:{
	        		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
	        		if(sp.getBoolean("darkmode",false))
	        			text.setText("FeelThePowerOfDark");
	        		else
	        			text.setText("FeelThePowerOfLight");
	        		break;
	        	}
	        		
	        		
	        }
	    }

}
