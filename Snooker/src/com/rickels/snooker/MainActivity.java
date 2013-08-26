package com.rickels.snooker;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.LinearLayout;

import org.apache.cordova.DroidGap;
import com.google.ads.*;
import android.os.Handler;

public class MainActivity extends DroidGap {
	
	private Handler mHandler = new Handler();
    private AdView adView;
	
    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.loadUrl("file:///android_asset/www/index.html");
        
        mHandler.postDelayed(new Runnable() {
            public void run() {
                doAdMob();
            }
        }, 5000); 
        
    }


    //@Override
    //public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    //    getMenuInflater().inflate(R.menu.main, menu);
    //    return true;
    //}
    
    private void doAdMob() {
        // Create the adView
        adView = new AdView(this, AdSize.BANNER, "a151f6da479f89f");
        // Lookup your LinearLayout - get the super.root
        LinearLayout layout = super.root;
        // Add the adView to it
        layout.addView(adView);
        // This centers the ads in landscape mode.        
        layout.setHorizontalGravity(android.view.Gravity.CENTER_HORIZONTAL);
        // Initiate a generic request to load it with an ad
        AdRequest request = new AdRequest();
        // and finally...     
        adView.loadAd(request);                    
    }
    
}
