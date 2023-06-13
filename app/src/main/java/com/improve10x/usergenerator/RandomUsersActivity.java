package com.improve10x.usergenerator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.improve10x.usergenerator.databinding.ActivityRandomUsersBinding;
import com.improve10x.usergenerator.model.User;

import java.util.ArrayList;
import java.util.List;

public class RandomUsersActivity extends AppCompatActivity {

    private ArrayList<User> users;

    private ActivityRandomUsersBinding activityRandomUsersBinding;

    private RandomUserAdapter randomUserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityRandomUsersBinding = ActivityRandomUsersBinding.inflate(getLayoutInflater());
        setContentView(activityRandomUsersBinding.getRoot());
        getSupportActionBar().setTitle("Random User");

    }

}