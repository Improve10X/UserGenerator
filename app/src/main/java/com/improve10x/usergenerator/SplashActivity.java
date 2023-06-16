package com.improve10x.usergenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        displaySplash();
    }

    private void displaySplash() {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
                    finish();
                    Intent mainIntent = new Intent(this, HomeActivity.class);
                    startActivity(mainIntent);
                }, 1500
        );
    }
}