package com.improve10x.usergenerator;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.usergenerator.databinding.RandomUserItemBinding;
import com.improve10x.usergenerator.model.User;

import java.util.List;

public class RandomUsersAdapter extends RecyclerView.Adapter<RandomViewHolder> {

    private List<User> users;
    private OnItemActionListener actionListener;

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
        User user = users.get(position);
        holder.randomUserItemBinding.setUser(user);
        holder.randomUserItemBinding.saveBtn.setOnClickListener(v -> {
            actionListener.saveUser(user);
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
