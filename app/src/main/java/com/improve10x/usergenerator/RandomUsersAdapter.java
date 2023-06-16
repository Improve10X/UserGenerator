package com.improve10x.usergenerator;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.usergenerator.databinding.RandomUserItemBinding;
import com.improve10x.usergenerator.model.User;
import com.improve10x.usergenerator.users.OnClickListener;

import java.util.List;

public class RandomUsersAdapter extends RecyclerView.Adapter<RandomUserViewHolder> {

    private List<User> users;
    private OnClickListener clickListener;
    private boolean showSave = false;
    private boolean showDelete = false;

    public void setShowSave(boolean showSave) {
        this.showSave = showSave;
    }

    public void setShowDelete(boolean showDelete) {
        this.showDelete = showDelete;
    }

    public RandomUsersAdapter(List<User> users) {
        this.users = users;
    }

    public void setData(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    public void setOnClickedListener(OnClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public RandomUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RandomUserItemBinding randomUserItemBinding = RandomUserItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        RandomUserViewHolder randomUserViewHolder = new RandomUserViewHolder(randomUserItemBinding);
        return randomUserViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RandomUserViewHolder holder, int position) {
        User user = users.get(position);
        holder.binding.setUser(user);
        holder.binding.setShowSave(showSave);
        holder.binding.setShowDelete(showDelete);
        holder.binding.saveBtn.setOnClickListener(v -> {
            clickListener.onSaveClicked(user);
        });
        holder.binding.deleteBtn.setOnClickListener(v -> {
            clickListener.onDeleteClicked(user.getId());
        });
        holder.binding.detailsBtn.setOnClickListener(v -> {
            clickListener.onItemDetailsClicked(user);
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
