package com.improve10x.usergenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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
        if(getIntent().hasExtra("User")) {
           user = (User) getIntent().getSerializableExtra("User");
        }
        showData();
    }

    private void showData() {
        binding.nameTxt.setText(user.getName());
        binding.designationTxt.setText(user.getJob());
        binding.emailTxt.setText(user.getEmail());
        binding.incomeTxt.setText(String.valueOf(user.getIncomeUsd()));
        binding.creditscoreTxt.setText(String.valueOf(user.getCreditScore()));
        binding.addressTxt.setText(user.getAddress().getStreetAddress()+", "+user.getAddress().getCity()+", " +user.getAddress().getCountryCode()+user.getAddress().getZipCode());
        binding.marriedTxt.setText(String.valueOf(user.getMarried()));
        binding.heightTxt.setText(String.valueOf(user.getHeightInCms()));
        binding.weightTxt.setText(String.valueOf(user.getWeightInKgs()));
    }
}