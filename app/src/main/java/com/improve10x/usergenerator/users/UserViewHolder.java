package com.improve10x.usergenerator.users;

import androidx.recyclerview.widget.RecyclerView;


import com.improve10x.usergenerator.databinding.UserItemBinding;

public class UserViewHolder extends RecyclerView.ViewHolder {

    UserItemBinding binding;

    public UserViewHolder(UserItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
