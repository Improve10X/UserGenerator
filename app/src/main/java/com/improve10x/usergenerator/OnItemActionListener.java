package com.improve10x.usergenerator;

import com.improve10x.usergenerator.model.User;

public interface OnItemActionListener {

    void saveUser(User user);
    void userDetails(User user);
}
