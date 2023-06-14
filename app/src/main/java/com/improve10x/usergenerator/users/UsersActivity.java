package com.improve10x.usergenerator.users;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.improve10x.usergenerator.R;
import com.improve10x.usergenerator.databinding.ActivityUsersBinding;

public class UsersActivity extends AppCompatActivity {

    private ActivityUsersBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUsersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}