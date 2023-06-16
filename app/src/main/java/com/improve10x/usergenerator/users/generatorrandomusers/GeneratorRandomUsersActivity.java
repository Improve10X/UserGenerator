package com.improve10x.usergenerator.users.generatorrandomusers;


import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.improve10x.usergenerator.BaseActivity;
import com.improve10x.usergenerator.Constants;
import com.improve10x.usergenerator.UserDetailsActivity;
import com.improve10x.usergenerator.users.OnItemActionListener;
import com.improve10x.usergenerator.users.UsersAdapter;
import com.improve10x.usergenerator.databinding.ActivityGenerateRandomUsersBinding;
import com.improve10x.usergenerator.model.User;
import com.improve10x.usergenerator.network.crudnetwork.CrudUserApi;
import com.improve10x.usergenerator.network.crudnetwork.CrudUserApiService;
import com.improve10x.usergenerator.network.pepolegeneratornetwork.PeopleGeneratorApi;
import com.improve10x.usergenerator.network.pepolegeneratornetwork.PeopleGeneratorApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GeneratorRandomUsersActivity extends BaseActivity {

    private ArrayList<User> users = new ArrayList<>();
    private UsersAdapter usersAdapter;
    private ActivityGenerateRandomUsersBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGenerateRandomUsersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Random Users");
        getUsers();
        setupAdapter();
        setupRecyclerView();
    }

    private void getUsers() {
        showProgressDialog("Loading");
        PeopleGeneratorApiService peopleGeneratorApiService = new PeopleGeneratorApi().createPeopleGeneratorApiService();
        Call<List<User>> call = peopleGeneratorApiService.fetchGeneratorUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                hideProgressDialog();
                List<User> generateRandomUsers = response.body();
                usersAdapter.setUsers(generateRandomUsers);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                hideProgressDialog();
                showToast("Failed To Load Data");
            }
        });
    }

    private void setupAdapter() {
        usersAdapter = new UsersAdapter();
        usersAdapter.setUsers(users);
        usersAdapter.setShowSaveBtn(true);
        setOnItemActionListener();
    }

    private void setupRecyclerView() {
        binding.generateRandomUsersRv.setLayoutManager(new LinearLayoutManager(this));
        binding.generateRandomUsersRv.setAdapter(usersAdapter);
    }

    private void createUser(User user) {
        showProgressDialog("Saving the user");
        CrudUserApiService crudUserApiService = new CrudUserApi().createCrudUserApiService();
        Call<User> call = crudUserApiService.createUser(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                hideProgressDialog();
                showToast("Saved Successfully");
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                hideProgressDialog();
                showToast("Save Failed");
            }
        });
    }

    private void setOnItemActionListener() {
        usersAdapter.setOnItemActionListener(new OnItemActionListener() {
            @Override
            public void onSave(User user) {
                createUser(user);
            }

            @Override
            public void onDelete(String id) {
            }

            @Override
            public void onDetails(User user) {
                Intent intent = new Intent(GeneratorRandomUsersActivity.this, UserDetailsActivity.class);
                intent.putExtra(Constants.KEY_RANDOM_USER, user);
                startActivity(intent);
            }
        });
    }
}