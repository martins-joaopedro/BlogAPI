package com.joaopd.blog.application.core.service;

import java.util.List;

import com.joaopd.blog.adapter.in.entities.PostEntity;
import com.joaopd.blog.application.core.domain.Post;
import com.joaopd.blog.application.core.dto.PostDTO;
import com.joaopd.blog.application.ports.in.PostServicePort;
import com.joaopd.blog.application.ports.out.PostRepositoryPort;

public class PostService implements PostServicePort {

    private final PostRepositoryPort repository;

    public PostService(PostRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public List<Post> findAllPosts() {
        return this.repository.findAll(); 
    }

    @Override
    public Post findPostById(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void savePost(PostDTO p) {
        PostEntity entity = new PostEntity(p);
        this.repository.create(entity);
    }
    
}
