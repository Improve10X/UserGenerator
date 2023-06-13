package com.improve10x.usergenerator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.usergenerator.databinding.ActivityRandomUsersBinding;
import com.improve10x.usergenerator.model.User;
import com.improve10x.usergenerator.randomNetwork.RandomPeopleApi;
import com.improve10x.usergenerator.randomNetwork.RandomPeopleApiService;
import com.improve10x.usergenerator.usersNetwork.UsersApi;
import com.improve10x.usergenerator.usersNetwork.UsersApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RandomUsersActivity extends AppCompatActivity {

    private ArrayList<User>  users = new ArrayList<>();

    private ActivityRandomUsersBinding activityRandomUsersBinding;

    private RandomUserAdapter randomUserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityRandomUsersBinding = ActivityRandomUsersBinding.inflate(getLayoutInflater());
        setContentView(activityRandomUsersBinding.getRoot());
        getSupportActionBar().setTitle("Random User");
        connectAdapter();
        setupAdapter();
        fetchRandomUsers();
    }

    private void connectAdapter() {
        randomUserAdapter = new RandomUserAdapter();
        randomUserAdapter.setUsers(users);
        randomUserAdapter.setActionListener(new OnItemActionListener() {
            @Override
            public void saveUser(User user) {
                addUser(user);
            }
        });
    }

    private void setupAdapter() {
        activityRandomUsersBinding.randomUserRv.setLayoutManager(new LinearLayoutManager(this));
        activityRandomUsersBinding.randomUserRv.setAdapter(randomUserAdapter);
    }

    private void fetchRandomUsers() {
        RandomPeopleApi randomPeopleApi = new RandomPeopleApi();
        RandomPeopleApiService randomPeopleApiService = randomPeopleApi.createRandomPeopleApiService();
        Call<List<User>> call = randomPeopleApiService.getRandomPeople();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    List<User> userList = response.body();
                    randomUserAdapter.setUsers(userList);
                    Toast.makeText(RandomUsersActivity.this, "Successfully Fetched the data", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(RandomUsersActivity.this, "Failed to Fetch the data", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void addUser(User user){
       UsersApi usersApi = new UsersApi();
       UsersApiService usersApiService = usersApi.createUserApiService();
       Call<User> call = usersApiService.createUser(user);
       call.enqueue(new Callback<User>() {
           @Override
           public void onResponse(Call<User> call, Response<User> response) {
               if (response.isSuccessful()){
                   Toast.makeText(RandomUsersActivity.this, "Success", Toast.LENGTH_SHORT).show();
               finish();
               }
           }

           @Override
           public void onFailure(Call<User> call, Throwable t) {
               Toast.makeText(RandomUsersActivity.this, "Failure", Toast.LENGTH_SHORT).show();
           }
       });
    }
}