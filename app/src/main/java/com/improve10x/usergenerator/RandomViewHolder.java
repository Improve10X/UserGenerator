package com.improve10x.usergenerator;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.usergenerator.databinding.RandomUserItemBinding;

public class RandomViewHolder extends RecyclerView.ViewHolder {
    RandomUserItemBinding randomUserItemBinding;
    public RandomViewHolder(@NonNull RandomUserItemBinding randomUserItemBinding) {
        super(randomUserItemBinding.getRoot());
        this.randomUserItemBinding = randomUserItemBinding;
    }
}
