package com.improve10x.usergenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.improve10x.usergenerator.databinding.ActivityUserDetailsBinding;
import com.improve10x.usergenerator.model.User;

public class UserDetailsActivity extends AppCompatActivity {

     private ActivityUserDetailsBinding binding;
     private User user;

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
    }

    private void showData() {
        binding.setUser(user);
    }
}