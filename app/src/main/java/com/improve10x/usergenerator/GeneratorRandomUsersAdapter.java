package com.improve10x.usergenerator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.usergenerator.databinding.RandomUserItemBinding;
import com.improve10x.usergenerator.generaterandomuser.OnItemActionListener;
import com.improve10x.usergenerator.model.User;

import java.util.List;

public class GeneratorRandomUsersAdapter extends RecyclerView.Adapter<GeneratorRandomUserViewHolder> {
    private List<User> Users;

    private boolean showSave = false;

    private boolean showDelete = false;

    public void setShowSave(boolean showSave) {
        this.showSave = showSave;
    }

    public void setShowDelete(boolean showDelete) {
        this.showDelete = showDelete;
    }

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

        if (showSave) {
            holder.binding.saveBtn.setVisibility(View.VISIBLE);
        }else  {
            holder.binding.saveBtn.setVisibility(View.INVISIBLE);
        }

        if (showDelete) {
            holder.binding.deleteBtn.setVisibility(View.VISIBLE);
        }else {
            holder.binding.deleteBtn.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return Users.size();
    }
}
