package com.improve10x.usergenerator.generaterandomuser;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.usergenerator.databinding.RandomUserItemBinding;
import com.improve10x.usergenerator.model.User;

import java.util.List;

public class GenerateRandomUsersAdapter extends RecyclerView.Adapter<GenerateRandomUserViewHolder> {

    private List<User> generateRandomUsers;

    private OnItemActionListener onItemActionListener;

    void setGenerateRandomUsers(List<User> generateRandomUsers) {
        this.generateRandomUsers = generateRandomUsers;
        notifyDataSetChanged();
    }

    void setOnItemActionListener(OnItemActionListener onItemActionListener) {
        this.onItemActionListener = onItemActionListener;
    }

    @NonNull
    @Override
    public GenerateRandomUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RandomUserItemBinding binding = RandomUserItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        GenerateRandomUserViewHolder generateRandomUserViewHolder = new GenerateRandomUserViewHolder(binding);
        return generateRandomUserViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GenerateRandomUserViewHolder holder, int position) {
        User generateRandomUser = generateRandomUsers.get(position);
        holder.binding.userNameTxt.setText(generateRandomUser.getName());
        holder.binding.userJobTxt.setText(generateRandomUser.getJob());
        holder.binding.userEmailTxt.setText("email : " + generateRandomUser.getEmail());
        holder.binding.userIncomeTxt.setText("Income : $" + generateRandomUser.getIncomeUsd());
        holder.binding.userCreditScoreTxt.setText("Credit Score : " + generateRandomUser.getCreditScore());
        holder.binding.userAddressTxt.setText(generateRandomUser.getAddress().getStreetAddress() + ", " +generateRandomUser.getAddress().getCity() + ", " + generateRandomUser.getAddress().getZip());
        holder.binding.saveBtn.setOnClickListener(v -> {
            onItemActionListener.onSave(generateRandomUser);
        });
    }

    @Override
    public int getItemCount() {
        return generateRandomUsers.size();
    }
}
