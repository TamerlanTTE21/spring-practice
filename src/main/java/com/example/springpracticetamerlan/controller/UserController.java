package com.example.springpracticetamerlan.controller;

import com.example.springpracticetamerlan.Exception.InvalidEmailException;
import com.example.springpracticetamerlan.Exception.UserAlreadyExistException;
import com.example.springpracticetamerlan.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import java.util.Map;

@RestController
public class UserController {
//    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final Map<String, User> users = new HashMap<>();

    @GetMapping("/users")
    public User[] findAll() {

//        log.info("Текущее количество постов: ");
        return users.values().toArray(new User[0]);
    }

    @PostMapping("/users")
    public User create(@RequestBody User user) {

        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new InvalidEmailException();
        }

        for (User u : users.values())
            if (u.getEmail().equals(user.getEmail())) {
                throw new UserAlreadyExistException();
            }
        users.put(user.getEmail(), user);
        return user;
    }

    @PutMapping("users")
    public User update(@RequestBody User user) {
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new InvalidEmailException();
        }
        users.put(user.getEmail(), user);
        return user;
    }
}
