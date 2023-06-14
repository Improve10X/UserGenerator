package com.improve10x.usergenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.improve10x.usergenerator.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding activityHomeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHomeBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(activityHomeBinding.getRoot());
        handleGenerateRandomUsersBtn();
    }

    private void handleGenerateRandomUsersBtn() {
        activityHomeBinding.randomUserBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, RandomUsersActivity.class);
            startActivity(intent);
        });
    }
}