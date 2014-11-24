package com.thoughtworks.letusgo.service;

import com.thoughtworks.letusgo.entity.User;

public interface UserService {
    User getUserByName(String name);

    void addUser(User user);
}
