package com.improve10x.usergenerator.randomusergenerater;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.usergenerator.databinding.RandomUsersItemBinding;
import com.improve10x.usergenerator.modelclass.User;

import java.util.List;

public class RandomUsersGenerateAdapter extends RecyclerView.Adapter<RandomUserGenerateViewHolder> {

    private List<User> users;

    public RandomUsersGenerateAdapter(List<User> users) {
        this.users = users;
    }

    void setData(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RandomUserGenerateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RandomUsersItemBinding binding = RandomUsersItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        RandomUserGenerateViewHolder randomUserGenerateViewHolder = new RandomUserGenerateViewHolder(binding);
        return randomUserGenerateViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RandomUserGenerateViewHolder holder, int position) {
        User user = users.get(position);
        holder.randomUsersItemBinding.nameTxt.setText(user.getName());
        holder.randomUsersItemBinding.jobTxt.setText(user.getJob());
        holder.randomUsersItemBinding.emailTxt.setText(user.getEmail());
        holder.randomUsersItemBinding.incomeTxt.setText(String.valueOf(user.getIncomeUsd()));
        holder.randomUsersItemBinding.creditScoreTxt.setText(String.valueOf(user.getCreditScore()));
        holder.randomUsersItemBinding.addressTxt.setText(user.getAddress().getStreetAddress());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}

