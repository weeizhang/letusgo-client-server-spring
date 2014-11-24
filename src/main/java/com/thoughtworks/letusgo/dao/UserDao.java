package com.thoughtworks.letusgo.dao;

import com.thoughtworks.letusgo.entity.User;

public interface UserDao {
    User getUserByName(String name);

    void addUser(User user);
}
