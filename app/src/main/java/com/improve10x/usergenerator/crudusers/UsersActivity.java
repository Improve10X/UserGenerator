package com.improve10x.usergenerator.crudusers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.improve10x.usergenerator.databinding.ActivityUsersBinding;
import com.improve10x.usergenerator.GeneratorRandomUsersAdapter;
import com.improve10x.usergenerator.model.User;

import java.util.ArrayList;

public class UsersActivity extends AppCompatActivity {

    private ActivityUsersBinding binding;

    private GeneratorRandomUsersAdapter generatorRandomUsersAdapter;

    private ArrayList<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUsersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Users");
        setupAdapter();
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        binding.usersRv.setAdapter(generatorRandomUsersAdapter);
        binding.usersRv.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupAdapter() {
        generatorRandomUsersAdapter = new GeneratorRandomUsersAdapter();
        generatorRandomUsersAdapter.setUsers(users);
    }
}