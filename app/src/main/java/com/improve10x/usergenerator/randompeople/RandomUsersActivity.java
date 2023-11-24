package com.improve10x.usergenerator.randompeople;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.improve10x.usergenerator.Constants;
import com.improve10x.usergenerator.userdetailsactivity.UserDetailsActivity;
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

            @Override
            public void userDetails(User user) {
                Intent intent = new Intent(RandomUsersActivity.this, UserDetailsActivity.class);
                intent.putExtra(Constants.KEY_RANDOM_USERS_VALUE, user);
                startActivity(intent);
            }
        });
    }

    private void setupRandomUsersApiService() {
        RandomPeopleApi randomPeopleApi = new RandomPeopleApi();
        randomPeopleApiService = randomPeopleApi.createRandomPeopleApiService();
    }

    private void fetchRandomUsers() {
        showProgressBar();
        setupRandomUsersApiService();
        Call<List<User>> call = randomPeopleApiService.getRandomPeople();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                hideProgressBar();
                if (response.isSuccessful()) {
                    List<User> userList = response.body();
                    randomUsersAdapter.setUsers(userList);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                hideProgressBar();
                showToast("Failed to load the data");
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
                showToast("Failed to add the Data");
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void showProgressBar() {
        activityRandomUsersBinding.randomProgressBarPb.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        activityRandomUsersBinding.randomProgressBarPb.setVisibility(View.GONE);
    }
}