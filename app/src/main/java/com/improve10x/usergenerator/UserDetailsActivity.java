package com.improve10x.usergenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.improve10x.usergenerator.databinding.ActivityUserDetailsBinding;
import com.improve10x.usergenerator.model.User;

public class UserDetailsActivity extends AppCompatActivity {
   private ActivityUserDetailsBinding userDetailsBinding;
   private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userDetailsBinding = ActivityUserDetailsBinding.inflate(getLayoutInflater());
        setContentView(userDetailsBinding.getRoot());
        getSupportActionBar().setTitle("User Details");
        if(getIntent().hasExtra(Constants.KEY_RANDOM_USERS_VALUE)) {
             user = (User) getIntent().getSerializableExtra(Constants.KEY_RANDOM_USERS_VALUE);
        }
    }
}