package com.improve10x.usergenerator.users;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.improve10x.usergenerator.R;
import com.improve10x.usergenerator.databinding.ActivityUsersBinding;
import com.improve10x.usergenerator.model.User;
import com.improve10x.usergenerator.network.cruduserapi.CrudUserApi;
import com.improve10x.usergenerator.network.cruduserapi.CrudUsersService;
import com.improve10x.usergenerator.randomuser.RandomUsersAdapter;

import java.util.ArrayList;
import java.util.List;

public class UsersActivity extends AppCompatActivity {

    private List<User> users = new ArrayList<>();
    private ActivityUsersBinding binding;
    private CrudUsersService crudUsersService;
    private RandomUsersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUsersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupApi();
        setupAdapter();
        setupUsersRv();
    }

    private void setupApi() {
        CrudUserApi api = new CrudUserApi();
        crudUsersService = api.createCrudUserService();
    }

    private void setupAdapter() {
        adapter = new RandomUsersAdapter(users);
    }

    private void setupUsersRv() {
        binding.usersRv.setLayoutManager(new LinearLayoutManager(this));
        binding.usersRv.setAdapter(adapter);
    }
}