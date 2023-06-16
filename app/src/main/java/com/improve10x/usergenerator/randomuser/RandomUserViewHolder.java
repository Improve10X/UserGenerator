package com.improve10x.usergenerator.randomuser;

import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.usergenerator.databinding.RandomUserItemBinding;

public class RandomUserViewHolder extends RecyclerView.ViewHolder {
    RandomUserItemBinding binding;

    public RandomUserViewHolder(RandomUserItemBinding randomUserItemBinding) {
        super(randomUserItemBinding.getRoot());
        binding = randomUserItemBinding;
    }
}
