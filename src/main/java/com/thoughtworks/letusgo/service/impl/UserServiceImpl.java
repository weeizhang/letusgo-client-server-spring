package com.thoughtworks.letusgo.service.impl;

import com.thoughtworks.letusgo.dao.UserDao;
import com.thoughtworks.letusgo.entity.User;
import com.thoughtworks.letusgo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }
}
