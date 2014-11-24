package com.thoughtworks.letusgo.controller;

import com.thoughtworks.letusgo.entity.User;
import com.thoughtworks.letusgo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public User getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }
}
