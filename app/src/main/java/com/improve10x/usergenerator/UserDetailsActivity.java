package com.improve10x.usergenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.improve10x.usergenerator.databinding.ActivityUserDetailsBinding;
import com.improve10x.usergenerator.model.User;
import com.improve10x.usergenerator.network.crudnetwork.CrudUserApi;
import com.improve10x.usergenerator.network.crudnetwork.CrudUserApiService;
import com.improve10x.usergenerator.users.crudusers.UsersActivity;
import com.improve10x.usergenerator.users.generatorrandomusers.GenerateRandomUsersActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDetailsActivity extends AppCompatActivity {

     private ActivityUserDetailsBinding binding;
     private User user;

     private CrudUserApiService crudUserApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("User Details");
        if (getIntent().hasExtra(Constants.KEY_USER)) {
            user = (User) getIntent().getSerializableExtra(Constants.KEY_USER);
            binding.deleteBtn.setVisibility(View.VISIBLE);
            binding.saveBtn.setVisibility(View.INVISIBLE);
        } else if (getIntent().hasExtra(Constants.KEY_RANDOM_USER)) {
            user = (User) getIntent().getSerializableExtra(Constants.KEY_RANDOM_USER);
            binding.saveBtn.setVisibility(View.VISIBLE);
            binding.deleteBtn.setVisibility(View.INVISIBLE);
        }
        showData();
        handleSaveBtn();
        handleDeleteBtn();
    }

    private void showData() {
        binding.setUser(user);
    }

    private void createUser() {
        CrudUserApiService crudUserApiService = new CrudUserApi().createCrudUserApiService();
        Call<User> call = crudUserApiService.createUser(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(UserDetailsActivity.this, "Saved SuccessFully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(UserDetailsActivity.this, "Save Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void handleSaveBtn() {
        binding.saveBtn.setOnClickListener(v -> {
            createUser();
        });
    }

    private void deleteUser() {
        createCrudUserApiService();
        Call<Void> call = crudUserApiService.deleteUser(user.getId());
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(UserDetailsActivity.this, "Successfully deleted user", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(UserDetailsActivity.this, "Failed to delete user", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void handleDeleteBtn() {
        binding.deleteBtn.setOnClickListener(v -> {
            deleteUser();
        });
    }

    private void createCrudUserApiService() {
        CrudUserApi api = new CrudUserApi();
        crudUserApiService = api.createCrudUserApiService();
    }
}