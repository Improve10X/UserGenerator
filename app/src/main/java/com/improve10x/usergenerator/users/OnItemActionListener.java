package com.improve10x.usergenerator.users;

import com.improve10x.usergenerator.model.User;

public interface OnItemActionListener {

    void onSave(User user);

    void onDelete(String id);

    void onDetails(User user);
}
