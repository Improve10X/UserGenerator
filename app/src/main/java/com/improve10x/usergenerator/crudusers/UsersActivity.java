package com.improve10x.usergenerator.crudusers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.usergenerator.GeneratorRandomUsersAdapter;
import com.improve10x.usergenerator.databinding.ActivityUsersBinding;
import com.improve10x.usergenerator.model.User;
import com.improve10x.usergenerator.network.crudnetwork.CrudUserApi;
import com.improve10x.usergenerator.network.crudnetwork.CrudUserApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        getUsers();
        setupAdapter();
        setupRecyclerView();
    }

    private void getUsers() {
        CrudUserApi crudUserApi = new CrudUserApi();
        CrudUserApiService crudUserApiService = crudUserApi.createCrudUserApiService();
        Call<List<User>> call = crudUserApiService.fetchUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    List<User> users = response.body();
                    generatorRandomUsersAdapter.setUsers(users);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(UsersActivity.this, "Failed to load the data", Toast.LENGTH_SHORT).show();
            }
        });
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