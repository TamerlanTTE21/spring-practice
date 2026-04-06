package com.example.springpracticetamerlan.controller;

import com.example.springpracticetamerlan.model.Post;
import com.example.springpracticetamerlan.service.PostService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class PostController {
    private static final Logger log = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping("/posts")
    public List<Post> getPosts() {
      return postService.getPosts();
    }

    @PostMapping("/posts")
    public Post create(@RequestBody Post post) {
        return postService.create(post);

    }
}
