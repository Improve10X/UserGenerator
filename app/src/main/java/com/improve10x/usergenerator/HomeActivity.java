package com.improve10x.usergenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.improve10x.usergenerator.databinding.ActivityHomeBinding;
import com.improve10x.usergenerator.randomuser.RandomUsersActivity;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        handleGenerateRandomUserBtn();
    }

    private void handleGenerateRandomUserBtn() {
        binding.generateRandomUsersBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, RandomUsersActivity.class);
            startActivity(intent);
        });
    }
}