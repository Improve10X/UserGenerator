package com.improve10x.usergenerator.generaterandomuser;

import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.usergenerator.databinding.RandomUserItemBinding;

public class GeneratorRandomUserViewHolder extends RecyclerView.ViewHolder {

    RandomUserItemBinding binding;

    public GeneratorRandomUserViewHolder(RandomUserItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
