package com.improve10x.usergenerator;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.usergenerator.databinding.RandomUserItemBinding;
import com.improve10x.usergenerator.generaterandomuser.OnItemActionListener;
import com.improve10x.usergenerator.model.User;

import java.util.List;

public class BaseAdapter extends RecyclerView.Adapter<GeneratorRandomUserViewHolder> {
    private List<User> Users;

    private OnItemActionListener onItemActionListener;

    public void setUsers(List<User> users) {
        this.Users = users;
        notifyDataSetChanged();
    }

    public void setOnItemActionListener(OnItemActionListener onItemActionListener) {
        this.onItemActionListener = onItemActionListener;
    }

    @NonNull
    @Override
    public GeneratorRandomUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RandomUserItemBinding binding = RandomUserItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        GeneratorRandomUserViewHolder generatorRandomUserViewHolder = new GeneratorRandomUserViewHolder(binding);
        return generatorRandomUserViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GeneratorRandomUserViewHolder holder, int position) {
        User user = Users.get(position);
        holder.binding.userNameTxt.setText(user.getName());
        holder.binding.userJobTxt.setText(user.getJob());
        holder.binding.userEmailTxt.setText("email : " + user.getEmail());
        holder.binding.userIncomeTxt.setText("Income : $" + user.getIncomeUsd());
        holder.binding.userCreditScoreTxt.setText("Credit Score : " + user.getCreditScore());
        holder.binding.userAddressTxt.setText(user.getAddress().getStreetAddress() + ", " +user.getAddress().getCity() + ", " + user.getAddress().getCountryCode() + " " + user.getAddress().getZipCode());
        holder.binding.saveBtn.setOnClickListener(v -> {
            onItemActionListener.onSave(user);
        });
    }

    @Override
    public int getItemCount() {
        return Users.size();
    }
}