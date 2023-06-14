package com.improve10x.usergenerator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.usergenerator.databinding.RandomUserItemBinding;
import com.improve10x.usergenerator.model.User;
import com.improve10x.usergenerator.randomuser.OnItemClickListener;

import java.util.List;

public class RandomUsersAdapter extends RecyclerView.Adapter<RandomUserViewHolder> {

    private List<User> users;
    private OnItemClickListener listener;
    private boolean showSave = false;
    private boolean showDelete = false;

    public RandomUsersAdapter(List<User> users) {
        this.users = users;
    }

     public void setData(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    public void setOnItemListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public void setShowSave(boolean showSave){
        this.showSave = showSave;
        notifyDataSetChanged();
    }

    public void setShowDelete(boolean showDelete){
        this.showDelete = showDelete;
        notifyDataSetChanged();
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
        if(showSave == true){
            holder.binding.saveBtn.setVisibility(View.VISIBLE);
            holder.binding.deleteBtn.setVisibility(View.GONE);
        }
        if(showDelete == true){
            holder.binding.deleteBtn.setVisibility(View.VISIBLE);
            holder.binding.saveBtn.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
