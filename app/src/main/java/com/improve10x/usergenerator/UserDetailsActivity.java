package com.improve10x.usergenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.improve10x.usergenerator.databinding.ActivityUserDetailsBinding;
import com.improve10x.usergenerator.model.User;
import com.improve10x.usergenerator.network.cruduserapi.CrudUserApi;
import com.improve10x.usergenerator.network.cruduserapi.CrudUsersService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDetailsActivity extends AppCompatActivity {

    private ActivityUserDetailsBinding binding;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if (getIntent().hasExtra("User")) {
            user = (User) getIntent().getSerializableExtra("User");
            binding.uDDelete.setVisibility(View.VISIBLE);
            binding.uDSaveBtn.setVisibility(View.GONE);
        } else if (getIntent().hasExtra("randomUser")) {
            user = (User) getIntent().getSerializableExtra("randomUser");
            binding.uDDelete.setVisibility(View.GONE);
            binding.uDSaveBtn.setVisibility(View.VISIBLE);
        }
        showData();
        handleDeleteBtn();
        handleSaveBtn();
    }

    private void handleSaveBtn() {
        binding.uDSaveBtn.setOnClickListener(v -> {
            saveUser(user);
        });
    }

    private void handleDeleteBtn() {
        binding.uDDelete.setOnClickListener(v -> {
            deleteUser(user.getId());
        });
    }

    private void showData() {
        binding.setUser(user);
    }

    public void deleteUser(String id) {
        CrudUsersService crudUsersService = new CrudUserApi().createCrudUserService();
        Call<Void> call = crudUsersService.deleteUsers(id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(UserDetailsActivity.this, "userDeleted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    public void saveUser(User user) {
        CrudUsersService crudUsersService = new CrudUserApi().createCrudUserService();
        Call<User> call = crudUsersService.createUsers(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(UserDetailsActivity.this, "sucess", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

    }

}