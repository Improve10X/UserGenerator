package com.improve10x.usergenerator.randomuser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.usergenerator.RandomUsersAdapter;
import com.improve10x.usergenerator.UserDetailsActivity;
import com.improve10x.usergenerator.databinding.ActivityRandomUsersBinding;
import com.improve10x.usergenerator.model.User;
import com.improve10x.usergenerator.network.cruduserapi.CrudUserApi;
import com.improve10x.usergenerator.network.cruduserapi.CrudUsersService;
import com.improve10x.usergenerator.network.randompeopleapi.PeopleApi;
import com.improve10x.usergenerator.network.randompeopleapi.RandomPeopleService;
import com.improve10x.usergenerator.users.OnClickListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RandomUsersActivity extends AppCompatActivity {

    private ActivityRandomUsersBinding binding;
    private List<User> users = new ArrayList<>();
    private RandomUsersAdapter randomUsersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRandomUsersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupAdapter();
        setupRandomUsersRv();
        fetchRandomUsers();
    }

    private void setupAdapter () {
        randomUsersAdapter = new RandomUsersAdapter(users);
        randomUsersAdapter.setShowSave(true);
        randomUsersAdapter.setOnClickListener(new OnItemClickListener() {
            @Override
            public void onSaveClicked(User user) {
                createUser(user);
            }
        });
    }

    private void setupRandomUsersRv() {
        binding.randomUsersRv.setLayoutManager(new LinearLayoutManager(this));
        binding.randomUsersRv.setAdapter(randomUsersAdapter);
    }

    private void fetchRandomUsers() {
        RandomPeopleService randomPeopleService = new PeopleApi().createRandomPeopleService();
        Call<List<User>> call = randomPeopleService.fetchRandomPeople();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                randomUsersAdapter.setData(response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(RandomUsersActivity.this, "Fetch Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void createUser(User user){
        CrudUsersService crudUsersService = new CrudUserApi().createCrudUserService();
        Call<User> call = crudUsersService.createUsers(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(RandomUsersActivity.this, "successfully saved data", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(RandomUsersActivity.this, "failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}