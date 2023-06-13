package com.improve10x.usergenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.improve10x.usergenerator.databinding.ActivityHomeBinding;
import com.improve10x.usergenerator.randomusergenerater.RandomUserGenerateActivity;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        handleRandomUsersBtn();
    }

    private void handleRandomUsersBtn() {
        binding.gruBtn.setOnClickListener(v -> {
            Intent randomUsersIntent = new Intent(this, RandomUserGenerateActivity.class);
            startActivity(randomUsersIntent);
        });
    }
}