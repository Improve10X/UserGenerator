package com.improve10x.usergenerator.randomusergenerater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.usergenerator.databinding.ActivityRandomUserGenerateBinding;
import com.improve10x.usergenerator.modelclass.User;
import com.improve10x.usergenerator.network.RandomPeopleApi;
import com.improve10x.usergenerator.network.RandomPeopleService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RandomUserGenerateActivity extends AppCompatActivity {

    private ActivityRandomUserGenerateBinding binding;
    private RandomUsersGenerateAdapter randomUsersGenerateAdapter;
    private List<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRandomUserGenerateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Random Users");
        setupAdapter();
        setupRandomUsersRv();
        fetchRandomUsers();
    }

    private void setupAdapter() {
        randomUsersGenerateAdapter = new RandomUsersGenerateAdapter(users);
    }

    private void setupRandomUsersRv() {
        binding.randomUserGenerateRv.setLayoutManager(new LinearLayoutManager(this));
        binding.randomUserGenerateRv.setAdapter(randomUsersGenerateAdapter);
    }

    private void fetchRandomUsers() {
        RandomPeopleService randomPeopleService = new RandomPeopleApi().createRandomPeopleService();
        Call<List<User>> call = randomPeopleService.fetchRandomPeople();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                Toast.makeText(RandomUserGenerateActivity.this, "Fetch Success", Toast.LENGTH_SHORT).show();
                randomUsersGenerateAdapter.setData(response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(RandomUserGenerateActivity.this, "Fetch Random Users Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}