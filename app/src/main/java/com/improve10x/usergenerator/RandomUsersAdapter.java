package com.improve10x.usergenerator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.usergenerator.databinding.RandomUserItemBinding;
import com.improve10x.usergenerator.model.User;

import java.util.List;

public class RandomUsersAdapter extends RecyclerView.Adapter<RandomViewHolder> {

    private List<User> users;
    private  User user;
    private OnItemActionListener actionListener;
    private OnActionListener listener;

    void setListener(OnActionListener listener) {
        this.listener = listener;
    }

    private boolean showSave = false;
    private boolean showDelete = false;

    public void setShowSave(boolean showSave) {
        this.showSave = showSave;
        notifyDataSetChanged();
    }

    public void setShowDelete(boolean showDelete) {
        this.showDelete = showDelete;
        notifyDataSetChanged();
    }

    void setActionListener(OnItemActionListener actionListener) {
        this.actionListener = actionListener;
    }

    public void setUsers(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RandomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RandomUserItemBinding randomUserItemBinding = RandomUserItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        RandomViewHolder randomViewHolder = new RandomViewHolder(randomUserItemBinding);
        return randomViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RandomViewHolder holder, int position) {
        user = users.get(position);
        holder.randomUserItemBinding.setUser(user);
        holder.randomUserItemBinding.saveBtn.setOnClickListener(v -> {
            actionListener.saveUser(user);
        });
        if (showSave == true) {
            holder.randomUserItemBinding.saveBtn.setVisibility(View.VISIBLE);
            holder.randomUserItemBinding.deleteBtn.setVisibility(View.GONE);
        }
        if (showDelete == true) {
            holder.randomUserItemBinding.deleteBtn.setVisibility(View.VISIBLE);
            holder.randomUserItemBinding.saveBtn.setVisibility(View.GONE);
        }
        holder.randomUserItemBinding.deleteBtn.setOnClickListener(view -> {
            listener.deleteUser(user.getId());
        });
        holder.randomUserItemBinding.detailsBtn.setOnClickListener(v -> {
            actionListener.userDetails(user);
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
