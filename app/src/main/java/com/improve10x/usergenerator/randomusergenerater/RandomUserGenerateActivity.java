package com.improve10x.usergenerator.randomusergenerater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.improve10x.usergenerator.databinding.ActivityRandomUserGenerateBinding;
import com.improve10x.usergenerator.modelclass.User;

import java.util.ArrayList;
import java.util.List;

public class RandomUserGenerateActivity extends AppCompatActivity {

    private ActivityRandomUserGenerateBinding binding;
    private RandomUsersGenerateAdapter randomUsersGenerateAdapter;
    private List<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRandomUserGenerateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Random Users");
        setupAdapter();
        setupRandomUsersRv();
    }

    private void setupAdapter() {
        randomUsersGenerateAdapter = new RandomUsersGenerateAdapter(users);
    }

    private void setupRandomUsersRv() {
        binding.randomUserGenerateRv.setLayoutManager(new LinearLayoutManager(this));
        binding.randomUserGenerateRv.setAdapter(randomUsersGenerateAdapter);
    }
}