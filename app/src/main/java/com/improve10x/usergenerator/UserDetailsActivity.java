package com.improve10x.usergenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.improve10x.usergenerator.databinding.ActivityUserDetailsBinding;
import com.improve10x.usergenerator.model.User;
import com.improve10x.usergenerator.network.usersNetwork.UsersApi;
import com.improve10x.usergenerator.network.usersNetwork.UsersApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDetailsActivity extends AppCompatActivity {
    private ActivityUserDetailsBinding userDetailsBinding;
    private User user;

    private UsersApiService usersApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userDetailsBinding = ActivityUserDetailsBinding.inflate(getLayoutInflater());
        setContentView(userDetailsBinding.getRoot());
        getSupportActionBar().setTitle("User Details");
        if (getIntent().hasExtra(Constants.KEY_USER_VALUE)) {
            user = (User) getIntent().getSerializableExtra(Constants.KEY_USER_VALUE);
            userDetailsBinding.deleteBtn.setVisibility(View.VISIBLE);
            userDetailsBinding.saveBtn.setVisibility(View.INVISIBLE);
        } else if (getIntent().hasExtra(Constants.KEY_RANDOM_USERS_VALUE)) {
            user = (User) getIntent().getSerializableExtra(Constants.KEY_RANDOM_USERS_VALUE);
            userDetailsBinding.deleteBtn.setVisibility(View.INVISIBLE);
            userDetailsBinding.saveBtn.setVisibility(View.VISIBLE);
        }
        userDetailsBinding.setUser(user);
        handleBtn();
    }

    private void addUserDetails() {
        createApiService();
        Call<User> call = usersApiService.createUser(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                showToast("Successfully added the data");
                finish();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                showToast("Failed to add the data");
            }
        });
    }

    private void deleteUserDetails() {
        createApiService();
        Call<Void> call = usersApiService.deleteUser(user.getId());
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                showToast("Successfully deleted the data");
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                showToast("failed to deleted the data");
            }
        });
    }

    private void createApiService() {
        UsersApi usersApi = new UsersApi();
        usersApiService = usersApi.createUserApiService();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void handleBtn() {
        handleSaveBtn();
        handleDeleteBtn();
    }

    private void handleDeleteBtn() {
        userDetailsBinding.deleteBtn.setOnClickListener(view -> {
            deleteUserDetails();
        });
    }

    private void handleSaveBtn() {
        userDetailsBinding.saveBtn.setOnClickListener(v -> {
            addUserDetails();
        });
    }
}