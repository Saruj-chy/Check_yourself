package com.sd.saruj.check_yourself.Saruj;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.sd.saruj.check_yourself.R;

public class SplashScreenActivity extends AppCompatActivity {

    ProgressBar splashProgress;

    int SPLASH_TIME = 1000; //This is 3 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mySuperIntent = new Intent(getApplicationContext(), YourSelfActivity.class);
                startActivity(mySuperIntent);
                finish();

            }
        }, SPLASH_TIME);
    }


}