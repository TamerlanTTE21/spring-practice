package com.example.springpracticetamerlan.service;

import com.example.springpracticetamerlan.exception.InvalidEmailException;
import com.example.springpracticetamerlan.exception.UserAlreadyExistException;
import com.example.springpracticetamerlan.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;
@Service
@Slf4j
public class UserService {

    private final Map<String, User> users = new HashMap<>();


    public User[] findAll() {
        log.info("Текущее количество постов: " + users.size());
        return users.values().toArray(new User[0]);
    }

    public User create( User user) {

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

    public User update(User user) {
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new InvalidEmailException();
        }
        users.put(user.getEmail(), user);
        return user;
    }

    public User getUserByEmail(String email) {
        for (User u : users.values()) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
    return null;
    }

}
