package com.example.springpracticetamerlan.controller;

import com.example.springpracticetamerlan.model.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

@RestController
public class PostContoller {

private final List<Post> posts = new ArrayList<>();

    @GetMapping("/posts")
    public List<Post> getPosts() {
        return posts;
    }

    @PostMapping("/posts")
    public Post create(@RequestBody Post post) {
        posts.add(post);
        return post;
    }
}
