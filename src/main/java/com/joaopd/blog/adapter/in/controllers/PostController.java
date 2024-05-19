package com.joaopd.blog.adapter.in.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaopd.blog.application.core.domain.Post;
import com.joaopd.blog.application.core.dto.PostDTO;
import com.joaopd.blog.application.ports.in.PostServicePort;

@RestController
@RequestMapping("post")
public class PostController {
    
    private final PostServicePort service;

    PostController(PostServicePort service) {
        this.service = service;
    }

    @GetMapping
    public List<Post> getPosts() {
        return this.service.findAllPosts();
    }

    @PostMapping
    public void createPost(@RequestBody PostDTO pDTO) {
        this.service.savePost(pDTO);
    }
}
