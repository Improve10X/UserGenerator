package com.improve10x.usergenerator;

import android.os.Bundle;
import android.view.View;

import com.improve10x.usergenerator.databinding.ActivityUserDetailsBinding;
import com.improve10x.usergenerator.model.User;
import com.improve10x.usergenerator.network.crudnetwork.CrudUserApi;
import com.improve10x.usergenerator.network.crudnetwork.CrudUserApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDetailsActivity extends BaseActivity {

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

    private void handleSaveBtn() {
        binding.saveBtn.setOnClickListener(v -> {
            createUser();
        });
    }

    private void handleDeleteBtn() {
        binding.deleteBtn.setOnClickListener(v -> {
            deleteUser();
        });
    }

    private void deleteUser() {
        createCrudUserApiService();
        Call<Void> call = crudUserApiService.deleteUser(user.getId());
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                showToast("Successfully deleted user");
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                showToast("Failed to delete user");
            }
        });
    }

    private void createUser() {
        CrudUserApiService crudUserApiService = new CrudUserApi().createCrudUserApiService();
        Call<User> call = crudUserApiService.createUser(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                showToast("Saved SuccessFully");
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                showToast("Save Failed");
            }
        });
    }

    private void createCrudUserApiService() {
        CrudUserApi api = new CrudUserApi();
        crudUserApiService = api.createCrudUserApiService();
    }
}