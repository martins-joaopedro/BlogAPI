package com.joaopd.blog.adapter.in.controllers;

import java.util.List;

import com.joaopd.blog.adapter.in.entities.PostEntity;
import com.joaopd.blog.application.core.dto.CommentDTO;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/{id}/comment")
    public void commentPost(@PathVariable String id, @RequestBody CommentDTO dto) {
        this.service.commentPost(id, dto);
    }
}
