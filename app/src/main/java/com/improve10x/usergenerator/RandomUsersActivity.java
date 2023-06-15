package com.improve10x.usergenerator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.usergenerator.databinding.ActivityRandomUsersBinding;
import com.improve10x.usergenerator.model.User;
import com.improve10x.usergenerator.network.randomNetwork.RandomPeopleApi;
import com.improve10x.usergenerator.network.randomNetwork.RandomPeopleApiService;
import com.improve10x.usergenerator.network.usersNetwork.UsersApi;
import com.improve10x.usergenerator.network.usersNetwork.UsersApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RandomUsersActivity extends AppCompatActivity {

    private ArrayList<User> users = new ArrayList<>();

    private ActivityRandomUsersBinding activityRandomUsersBinding;

    private RandomUsersAdapter randomUsersAdapter;

    private RandomPeopleApiService randomPeopleApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityRandomUsersBinding = ActivityRandomUsersBinding.inflate(getLayoutInflater());
        setContentView(activityRandomUsersBinding.getRoot());
        getSupportActionBar().setTitle("Random User");
        fetchRandomUsers();
        setupAdapter();
        setupRandomUsersRv();
    }

    private void setupRandomUsersRv() {
        activityRandomUsersBinding.randomUserRv.setLayoutManager(new LinearLayoutManager(this));
        activityRandomUsersBinding.randomUserRv.setAdapter(randomUsersAdapter);
    }

    private void setupAdapter() {
        randomUsersAdapter = new RandomUsersAdapter();
        randomUsersAdapter.setUsers(users);
        randomUsersAdapter.setShowSave(true);
        randomUsersAdapter.setActionListener(new OnItemActionListener() {
            @Override
            public void saveUser(User user) {
                addUser(user);
            }
        });
    }

    private void setupRandomUsersApiService() {
        RandomPeopleApi randomPeopleApi = new RandomPeopleApi();
        randomPeopleApiService = randomPeopleApi.createRandomPeopleApiService();
    }

    private void fetchRandomUsers() {
        setupRandomUsersApiService();
        Call<List<User>> call = randomPeopleApiService.getRandomPeople();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    List<User> userList = response.body();
                    randomUsersAdapter.setUsers(userList);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(RandomUsersActivity.this, "Failed to fetch the data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void addUser(User user) {
        UsersApi usersApi = new UsersApi();
        UsersApiService usersApiService = usersApi.createUserApiService();
        Call<User> call = usersApiService.createUser(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    finish();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(RandomUsersActivity.this, "Failed to add the data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}