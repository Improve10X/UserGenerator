package com.improve10x.usergenerator.randompeople;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.usergenerator.usersactivity.OnActionListener;
import com.improve10x.usergenerator.databinding.RandomUserItemBinding;
import com.improve10x.usergenerator.model.User;

import java.util.List;

public class RandomUsersAdapter extends RecyclerView.Adapter<RandomViewHolder> {

    private List<User> users;
    protected OnItemActionListener actionListener;
    protected OnActionListener listener;
    public void setListener(OnActionListener listener) {
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

    public void setActionListener(OnItemActionListener actionListener) {
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
        holder.randomUserItemBinding.setShowSave(showSave);
        holder.randomUserItemBinding.setShowDelete(showDelete);
        holder.randomUserItemBinding.saveBtn.setOnClickListener(v -> {
            actionListener.saveUser(user);
        });
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
