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

public class UserDetailsActivity extends BaseActivity {
    private ActivityUserDetailsBinding binding;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        checkReceiveData();
        showData();
        handleDeleteBtn();
        handleSaveBtn();
    }

    private void checkReceiveData() {
        if (getIntent().hasExtra("User")) {
            user = (User) getIntent().getSerializableExtra("User");
            binding.uDDelete.setVisibility(View.VISIBLE);
            binding.uDSaveBtn.setVisibility(View.GONE);
        } else if (getIntent().hasExtra("randomUser")) {
            user = (User) getIntent().getSerializableExtra("randomUser");
            binding.uDDelete.setVisibility(View.GONE);
            binding.uDSaveBtn.setVisibility(View.VISIBLE);
        }
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
        Call<Void> call = crudUsersService.deleteUser(id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                showToast("Successfully Deleted the Data");
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                showToast("Failed to Delete Data");
            }
        });
    }

    public void saveUser(User user) {
        CrudUsersService crudUsersService = new CrudUserApi().createCrudUserService();
        Call<User> call = crudUsersService.createUser(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                showToast("Successfully Saved the Data");
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                showToast("Failed to Save Data");
            }
        });
    }
}