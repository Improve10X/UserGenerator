package com.improve10x.usergenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.improve10x.usergenerator.databinding.ActivityGenerateRandomUsersBinding;
import com.improve10x.usergenerator.databinding.ActivityHomeBinding;
import com.improve10x.usergenerator.generaterandomuser.GenerateRandomUsersActivity;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        handleGenerateRandomButton();
    }

    private void handleGenerateRandomButton() {
        binding.generateRandomUsersBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, GenerateRandomUsersActivity.class);
            startActivity(intent);
        });
    }
}