package com.improve10x.usergenerator.generaterandomuser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.usergenerator.databinding.ActivityGenerateRandomUsersBinding;
import com.improve10x.usergenerator.model.User;
import com.improve10x.usergenerator.network.PeopleGenerateApi;
import com.improve10x.usergenerator.network.PeopleGenerateApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GenerateRandomUsersActivity extends AppCompatActivity {

    private ArrayList<User> generateRandomUsers = new ArrayList<>();
    private GenerateRandomUsersAdapter generateRandomUsersAdapter;
    private ActivityGenerateRandomUsersBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGenerateRandomUsersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Random Users");
        getGenerateRandomUsers();
        setupGenerateRandomUsersAdapter();
        setupGenerateRandomUsersRv();
    }

    private void getGenerateRandomUsers() {
        PeopleGenerateApi peopleGenerateApi = new PeopleGenerateApi();
        PeopleGenerateApiService peopleGenerateApiService = peopleGenerateApi.createPeopleGenerateApiService();
        Call<List<User>> call = peopleGenerateApiService.fetchPeopleGenerateUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> generateRandomUsers = response.body();
                generateRandomUsersAdapter.setGenerateRandomUsers(generateRandomUsers);
                Toast.makeText(GenerateRandomUsersActivity.this, "Successfully Loaded Data", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(GenerateRandomUsersActivity.this, "Failed To Load Data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupGenerateRandomUsersAdapter() {
        generateRandomUsersAdapter = new GenerateRandomUsersAdapter();
        generateRandomUsersAdapter.setGenerateRandomUsers(generateRandomUsers);
    }

    private void setupGenerateRandomUsersRv() {
        binding.generateRandomUsersRv.setLayoutManager(new LinearLayoutManager(this));
        binding.generateRandomUsersRv.setAdapter(generateRandomUsersAdapter);
    }
}