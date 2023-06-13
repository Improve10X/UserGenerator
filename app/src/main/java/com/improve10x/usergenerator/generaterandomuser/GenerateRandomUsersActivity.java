package com.improve10x.usergenerator.generaterandomuser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.improve10x.usergenerator.databinding.ActivityGenerateRandomUsersBinding;
import com.improve10x.usergenerator.model.User;

import java.util.ArrayList;

public class GenerateRandomUsersActivity extends AppCompatActivity {

    private ArrayList<User> generateRandomUsers = new ArrayList<>();

    private GenerateRandomUsersAdapter generateRandomUsersAdapter;

    private ActivityGenerateRandomUsersBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGenerateRandomUsersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Random Users");
        setupGenerateRandomUsersRv();
        setupGenerateAdapter();
    }

    private void setupGenerateAdapter() {
        generateRandomUsersAdapter = new GenerateRandomUsersAdapter();
        generateRandomUsersAdapter.setGenerateRandomUsers(generateRandomUsers);
    }

    private void setupGenerateRandomUsersRv() {
        binding.generateRandomUsersRv.setLayoutManager(new LinearLayoutManager(this));
        binding.generateRandomUsersRv.setAdapter(generateRandomUsersAdapter);

    }
}