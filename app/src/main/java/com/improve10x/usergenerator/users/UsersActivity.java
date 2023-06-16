package com.improve10x.usergenerator.users;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.usergenerator.UserDetailsActivity;
import com.improve10x.usergenerator.databinding.ActivityUsersBinding;
import com.improve10x.usergenerator.model.User;
import com.improve10x.usergenerator.network.cruduserapi.CrudUserApi;
import com.improve10x.usergenerator.network.cruduserapi.CrudUsersService;
import com.improve10x.usergenerator.randomuser.RandomUsersAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    @Override
    protected void onResume() {
        super.onResume();
        fetchCrudUsers();
    }

    private void deleteCrudUser(String id) {
        Call<Void> call = crudUsersService.deleteUser(id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                fetchCrudUsers();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(UsersActivity.this, "failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupApi() {
        CrudUserApi api = new CrudUserApi();
        crudUsersService = api.createCrudUserService();
    }

    private void setupAdapter() {
        adapter = new RandomUsersAdapter(users);
        adapter.setShowDelete(true);
        adapter.setOnClickedListener(new OnClickListener() {
            @Override
            public void onDeleteClicked(String id) {
                deleteCrudUser(id);
            }

            @Override
            public void onItemDetailsClicked(User user) {
                updateUser(user);
            }

            @Override
            public void onSaveClicked(User user) {
            }
        });
    }

    private void setupUsersRv() {
        binding.usersRv.setLayoutManager(new LinearLayoutManager(this));
        binding.usersRv.setAdapter(adapter);
    }

    private void fetchCrudUsers() {
        Call<List<User>> call = crudUsersService.fetchUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                adapter.setData(response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(UsersActivity.this, "fetchFailed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateUser(User user) {
        Intent intent = new Intent(this, UserDetailsActivity.class);
        intent.putExtra("User",user);
        startActivity(intent);
    }
}