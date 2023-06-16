package com.improve10x.usergenerator.randomuser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.usergenerator.BaseActivity;
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

public class RandomUsersActivity extends BaseActivity {
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

    private void setupAdapter() {
        randomUsersAdapter = new RandomUsersAdapter(users);
        randomUsersAdapter.setShowSave(true);
        randomUsersAdapter.setOnClickedListener(new OnClickListener() {
            @Override
            public void onDeleteClicked(String id) {
            }

            @Override
            public void onItemDetailsClicked(User user) {
            upDateRandomUser(user);
            }

            @Override
            public void onSaveClicked(User user) {
            createUser(user);
            }
        });
    }

    private void upDateRandomUser(User user) {
        Intent intent = new Intent(this,UserDetailsActivity.class);
        intent.putExtra("randomUser", user);
        startActivity(intent);
    }

    private void setupRandomUsersRv() {
        binding.randomUsersRv.setLayoutManager(new LinearLayoutManager(this));
        binding.randomUsersRv.setAdapter(randomUsersAdapter);
    }

    private void fetchRandomUsers() {
        RandomPeopleService randomPeopleService = new PeopleApi().createRandomPeopleService();
        Call<List<User>> call = randomPeopleService.fetchRandomPeopleGenerator();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    randomUsersAdapter.setData(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                showToast("Failed the Load Data");
            }
        });
    }

    private void createUser(User user){
        CrudUsersService crudUsersService = new CrudUserApi().createCrudUserService();
        Call<User> call = crudUsersService.createUser(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                showToast("Successfully Saved the Data");
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                showToast("Failed to Save the Data");
            }
        });
    }
}