package com.improve10x.usergenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.improve10x.usergenerator.databinding.ActivityGenerateRandomUsersBinding;

public class GenerateRandomUsersActivity extends AppCompatActivity {

    private ActivityGenerateRandomUsersBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGenerateRandomUsersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Random Users");
    }
}