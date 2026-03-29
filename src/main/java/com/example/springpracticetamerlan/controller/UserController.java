package com.example.springpracticetamerlan.controller;

import com.example.springpracticetamerlan.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

import java.util.Map;

@RestController
public class UserController {

    private final Map<User, User> users = new HashMap<>();

    @GetMapping("/users")
    public Map<User, User> getUsers() {
        return users;
    }

    @PostMapping("/users")
    public User create(@RequestBody User user) {
        users.put(user, user);
        return user;
    }
}
