package com.improve10x.usergenerator.users;

import com.improve10x.usergenerator.model.User;

public interface OnClickListener {
    void onDeleteClicked(String id);
    void onItemDetailsClicked(User user);
    void onSaveClicked(User user);
}
