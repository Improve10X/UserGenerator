package com.improve10x.usergenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.improve10x.usergenerator.databinding.ActivityRandomUsersBinding;
import com.improve10x.usergenerator.model.User;

import java.util.List;

public class RandomUsersActivity extends AppCompatActivity {

    ActivityRandomUsersBinding binding;

    private List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRandomUsersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Random User");
    }
}