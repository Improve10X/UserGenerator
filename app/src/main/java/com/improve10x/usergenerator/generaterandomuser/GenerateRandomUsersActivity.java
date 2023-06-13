package com.improve10x.usergenerator.generaterandomuser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.usergenerator.databinding.ActivityGenerateRandomUsersBinding;
import com.improve10x.usergenerator.model.User;
import com.improve10x.usergenerator.network.CrudUserApi;
import com.improve10x.usergenerator.network.CrudUserApiService;
import com.improve10x.usergenerator.network.OnItemActionListener;
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
        generateRandomUsersAdapter.setOnItemActionListener(new OnItemActionListener() {
            @Override
            public void onSave(User user) {
                createUser(user);
            }
        });
    }

    private void setupGenerateRandomUsersRv() {
        binding.generateRandomUsersRv.setLayoutManager(new LinearLayoutManager(this));
        binding.generateRandomUsersRv.setAdapter(generateRandomUsersAdapter);
    }

    private void createUser(User user) {
        CrudUserApiService crudUserApiService = new CrudUserApi().createCrudUserApiService();
        Call<User> call = crudUserApiService.createUser(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(GenerateRandomUsersActivity.this, "Saved SuccessFully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(GenerateRandomUsersActivity.this, "Save Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}