package com.example.springpracticetamerlan.controller;

import com.example.springpracticetamerlan.exception.InvalidEmailException;
import com.example.springpracticetamerlan.exception.UserAlreadyExistException;
import com.example.springpracticetamerlan.model.User;
import com.example.springpracticetamerlan.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashMap;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Collection<User> findAll(@RequestParam(required = false) String country){
        return userService.findAll(country);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
}
