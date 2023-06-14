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

    private OnItemActionListener onItemActionListener;

    private boolean showSaveBtn = false;

    private boolean showDeleteBtn = false;

    public void setShowSaveBtn(boolean showSaveBtn) {
        this.showSaveBtn = showSaveBtn;
    }

    public void setShowDeleteBtn(boolean showDeleteBtn) {
        this.showDeleteBtn = showDeleteBtn;
    }

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
        holder.binding.deleteBtn.setOnClickListener(v -> {
            onItemActionListener.onDelete(user.getId());
        });
        setSaveBtnVisibility(holder);
        setDeleteBtnVisibility(holder);
    }

    @Override
    public int getItemCount() {
        return Users.size();
    }

    private void setSaveBtnVisibility(GeneratorRandomUserViewHolder holder) {
        if (showSaveBtn) {
            holder.binding.saveBtn.setVisibility(View.VISIBLE);
        } else {
            holder.binding.saveBtn.setVisibility(View.INVISIBLE);
        }
    }

    private void setDeleteBtnVisibility(GeneratorRandomUserViewHolder holder) {
        if (showDeleteBtn) {
            holder.binding.deleteBtn.setVisibility(View.VISIBLE);
        } else {
            holder.binding.deleteBtn.setVisibility(View.INVISIBLE);
        }
    }
}
