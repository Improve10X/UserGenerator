package com.improve10x.usergenerator.crudusers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.improve10x.usergenerator.R;

public class UsersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        getSupportActionBar().setTitle("Users");
    }
}