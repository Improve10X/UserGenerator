package com.improve10x.usergenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.improve10x.usergenerator.databinding.ActivityHomeBinding;
import com.improve10x.usergenerator.randomuser.RandomUsersActivity;
import com.improve10x.usergenerator.users.UsersActivity;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        handleGenerateRandomUsersBtn();
        handleUsersBtn();
    }

    private void handleGenerateRandomUsersBtn() {
        binding.generateRandomUsersBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, RandomUsersActivity.class);
            startActivity(intent);
        });
    }

    private void handleUsersBtn() {
        binding.usersBtn.setOnClickListener(v -> {
            Intent usersIntent = new Intent(this, UsersActivity.class);
            startActivity(usersIntent);
        });
    }
}