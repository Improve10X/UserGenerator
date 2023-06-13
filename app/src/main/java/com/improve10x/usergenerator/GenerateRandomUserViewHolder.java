package com.improve10x.usergenerator;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.usergenerator.databinding.RandomUserItemBinding;

public class GenerateRandomUserViewHolder extends RecyclerView.ViewHolder {

    RandomUserItemBinding binding;

    public GenerateRandomUserViewHolder(RandomUserItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
