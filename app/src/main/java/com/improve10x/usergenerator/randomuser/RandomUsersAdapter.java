package com.improve10x.usergenerator.randomuser;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.usergenerator.databinding.RandomUserItemBinding;
import com.improve10x.usergenerator.model.User;

import java.util.List;

import retrofit2.Call;

public class RandomUsersAdapter extends RecyclerView.Adapter<RandomUserViewHolder> {

    private List<User> users;
    private OnItemClickListener listener;

    public RandomUsersAdapter(List<User> users) {
        this.users = users;
    }

    void setData(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    void setOnItemListener(OnItemClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public RandomUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RandomUserItemBinding randomUserItemBinding = RandomUserItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent,false);
        RandomUserViewHolder randomUserViewHolder = new RandomUserViewHolder(randomUserItemBinding);
        return randomUserViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RandomUserViewHolder holder, int position) {
        User user = users.get(position);
        holder.binding.nameTxt.setText(user.getName());
        holder.binding.emailTxt.setText(user.getEmail());
        holder.binding.creditScoreTxt.setText(String.valueOf(user.getCreditScore()));
        holder.binding.designationTxt.setText(user.getJob());
        holder.binding.incomeTxt.setText(String.valueOf(user.getIncomeUsd()));
        holder.binding.locationTxt.setText(user.getAddress().getStreetAddress() + ", "
                + user.getAddress().getCity() + ", " + user.getAddress().getCountryCode() +
                 user.getAddress().getZipCode());
        holder.binding.saveBtn.setOnClickListener(v -> {
            listener.onClicked(user);
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
