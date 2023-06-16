package com.improve10x.usergenerator.users.crudusers;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.improve10x.usergenerator.BaseActivity;
import com.improve10x.usergenerator.Constants;
import com.improve10x.usergenerator.UserDetailsActivity;
import com.improve10x.usergenerator.users.UsersAdapter;
import com.improve10x.usergenerator.databinding.ActivityUsersBinding;
import com.improve10x.usergenerator.users.OnItemActionListener;
import com.improve10x.usergenerator.model.User;
import com.improve10x.usergenerator.network.crudnetwork.CrudUserApi;
import com.improve10x.usergenerator.network.crudnetwork.CrudUserApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersActivity extends BaseActivity {

    private ActivityUsersBinding binding;
    private UsersAdapter usersAdapter;
    private ArrayList<User> users = new ArrayList<>();
    private CrudUserApiService crudUserApiService;

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
        showProgressDialog("Loading");
        createCrudUserApiService();
        Call<List<User>> call = crudUserApiService.fetchUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                hideProgressDialog();
                if (response.isSuccessful()) {
                    List<User> users = response.body();
                    usersAdapter.setUsers(users);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                hideProgressDialog();
                showToast("Failed to load the data");
            }
        });
    }

    private void setupRecyclerView() {
        binding.usersRv.setAdapter(usersAdapter);
        binding.usersRv.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupAdapter() {
        usersAdapter = new UsersAdapter();
        usersAdapter.setUsers(users);
        usersAdapter.setShowDeleteBtn(true);
        setOnItemActionListener();
    }

    private void deleteUser(String id) {
        showProgressDialog("Deleting the user");
        createCrudUserApiService();
        Call<Void> call = crudUserApiService.deleteUser(id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                hideProgressDialog();
                getUsers();
                showToast("Successfully deleted user");
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                hideProgressDialog();
                showToast("Failed to delete user");
            }
        });
    }

    private void createCrudUserApiService() {
        CrudUserApi api = new CrudUserApi();
        crudUserApiService = api.createCrudUserApiService();
    }

    private void setOnItemActionListener() {
        usersAdapter.setOnItemActionListener(new OnItemActionListener() {
            @Override
            public void onSave(User user) {
            }

            @Override
            public void onDelete(String id) {
                deleteUser(id);
            }

            @Override
            public void onDetails(User user) {
                Intent intent = new Intent(UsersActivity.this, UserDetailsActivity.class);
                intent.putExtra(Constants.KEY_USER, user);
                startActivity(intent);
            }
        });
    }
}