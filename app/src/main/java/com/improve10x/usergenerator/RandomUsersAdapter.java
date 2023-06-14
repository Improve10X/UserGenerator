package com.improve10x.usergenerator;

import android.view.View;

import androidx.annotation.NonNull;

public class RandomUsersAdapter extends BaseAdapter {

    @Override
    public void onBindViewHolder(@NonNull GeneratorRandomUserViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        holder.binding.saveBtn.setVisibility(View.VISIBLE);
    }
}