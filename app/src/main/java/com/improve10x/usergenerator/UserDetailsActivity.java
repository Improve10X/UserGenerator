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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userDetailsBinding = ActivityUserDetailsBinding.inflate(getLayoutInflater());
        setContentView(userDetailsBinding.getRoot());
        getSupportActionBar().setTitle("User Details");

        if (getIntent().hasExtra("User")) {
            user = (User) getIntent().getSerializableExtra("User");
            userDetailsBinding.deleteBtn.setVisibility(View.VISIBLE);
            userDetailsBinding.saveBtn.setVisibility(View.INVISIBLE);
        } else if(getIntent().hasExtra(Constants.KEY_RANDOM_USERS_VALUE)) {
            user = (User) getIntent().getSerializableExtra(Constants.KEY_RANDOM_USERS_VALUE);
            userDetailsBinding.deleteBtn.setVisibility(View.INVISIBLE);
            userDetailsBinding.saveBtn.setVisibility(View.VISIBLE);
        }
        userDetailsBinding.setUser(user);

        userDetailsBinding.deleteBtn.setOnClickListener(view -> {
            deleteUserDetails();
        });

        userDetailsBinding.saveBtn.setOnClickListener(v -> {
            addUserDetails();
        });
    }

    private void addUserDetails() {
        UsersApi usersApi = new UsersApi();
        UsersApiService usersApiService = usersApi.createUserApiService();
        Call <User> call = usersApiService.createUser(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(UserDetailsActivity.this, "Successfully added the data", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(UserDetailsActivity.this, "Failed to add data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteUserDetails(){
        UsersApiService usersApiService = new UsersApi().createUserApiService();
        Call<Void> call = usersApiService.deleteUser(user.getId());
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(UserDetailsActivity.this, "Deleted person details", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(UserDetailsActivity.this, "Failed to delete details", Toast.LENGTH_SHORT).show();
            }
        });
    }
}