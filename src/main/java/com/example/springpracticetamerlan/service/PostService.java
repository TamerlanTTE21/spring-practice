package com.example.springpracticetamerlan.service;
import com.example.springpracticetamerlan.controller.UserController;
import com.example.springpracticetamerlan.exception.InvalidEmailException;
import com.example.springpracticetamerlan.exception.UserNotFoundException;
import com.example.springpracticetamerlan.model.Post;
import com.example.springpracticetamerlan.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.ArrayList;
import java.util.List;

@Service

public class PostService {
    private final UserService userService;

    public PostService(UserService userService) {
        this.userService = userService;
    }

    private final List<Post> posts = new ArrayList<>();

    public List<Post> getPosts() {
        return posts;
    }

    public Post create( Post post) {
        User user = userService.getUserByEmail(post.getAuthor());
        if (user == null) {
            throw new UserNotFoundException();
        }
        posts.add(post);
        return post;
    }
}
