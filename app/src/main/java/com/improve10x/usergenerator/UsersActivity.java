package com.improve10x.usergenerator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.usergenerator.databinding.ActivityUsersBinding;
import com.improve10x.usergenerator.model.User;
import com.improve10x.usergenerator.network.usersNetwork.UsersApi;
import com.improve10x.usergenerator.network.usersNetwork.UsersApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersActivity extends AppCompatActivity {
    private ActivityUsersBinding activityUsersBinding;
    private RandomUsersAdapter randomUsersAdapter;

    private ArrayList<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityUsersBinding = ActivityUsersBinding.inflate(getLayoutInflater());
        setContentView(activityUsersBinding.getRoot());
        getSupportActionBar().setTitle("Users");
        setupUserAdapter();
        setupUserRv();
        fetchUsers();
    }

    private void setupUserRv() {
        activityUsersBinding.usersRv.setLayoutManager(new LinearLayoutManager(this));
        activityUsersBinding.usersRv.setAdapter(randomUsersAdapter);
    }

    private void setupUserAdapter() {
        randomUsersAdapter = new RandomUsersAdapter();
        randomUsersAdapter.setUsers(users);
        randomUsersAdapter.setShowDelete(true);
        randomUsersAdapter.setListener(new OnActionListener() {
            @Override
            public void deleteUser(String id) {
                deleteUserApi(id);
            }
        });
        randomUsersAdapter.setActionListener(new OnItemActionListener() {
            @Override
            public void saveUser(User user) {

            }

            @Override
            public void userDetails(User user) {
                Intent intent = new Intent(UsersActivity.this, UserDetailsActivity.class);
                intent.putExtra(Constants.KEY_USER_VALUE, user);
                startActivity(intent);
            }
        });
    }

    private void fetchUsers() {
        UsersApi usersApi = new UsersApi();
        UsersApiService usersApiService = usersApi.createUserApiService();
        Call<List<User>> call = usersApiService.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    List<User> userList = response.body();
                    randomUsersAdapter.setUsers(userList);
                    Toast.makeText(UsersActivity.this, "Successfully loaded the data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(UsersActivity.this, "Failed to fetch the data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteUserApi(String id) {
        UsersApiService usersApiService = new UsersApi().createUserApiService();
        Call<Void> call = usersApiService.deleteUser(id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(UsersActivity.this, "Deleted Item", Toast.LENGTH_SHORT).show();
                fetchUsers();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(UsersActivity.this, "Failed to delete item", Toast.LENGTH_SHORT).show();
            }
        });
    }
}