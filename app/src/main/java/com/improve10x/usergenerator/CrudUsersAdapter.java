package com.improve10x.usergenerator;

import android.view.View;

import androidx.annotation.NonNull;

public class CrudUsersAdapter extends BaseAdapter {

    @Override
    public void onBindViewHolder(@NonNull GeneratorRandomUserViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        holder.binding.deleteBtn.setVisibility(View.VISIBLE);
    }
}
