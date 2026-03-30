package com.example.springpracticetamerlan.controller;

import com.example.springpracticetamerlan.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

import java.util.Map;

@RestController
public class UserController {
//    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final Map<String, User> users = new HashMap<>();

    @GetMapping("/users")
    public Map<String, User> getUsers() {


//        log.info("Текущее количество постов: ");
        return users;
    }

//    @PostMapping("/users")
//    public User create(@RequestBody User user) {
//        users.put(user, user);
//        return user;
//    }
}
