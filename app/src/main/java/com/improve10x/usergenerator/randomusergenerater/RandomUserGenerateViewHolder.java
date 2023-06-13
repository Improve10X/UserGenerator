package com.improve10x.usergenerator.randomusergenerater;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.usergenerator.databinding.RandomUsersItemBinding;

public class RandomUserGenerateViewHolder extends RecyclerView.ViewHolder {
        RandomUsersItemBinding randomUsersItemBinding;

    public RandomUserGenerateViewHolder(RandomUsersItemBinding randomUsersItemBinding) {
        super(randomUsersItemBinding.getRoot());
       this.randomUsersItemBinding = randomUsersItemBinding;
    }
}
