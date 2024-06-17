package com.joaopd.blog.application.core.services;

import java.util.List;

import com.joaopd.blog.adapter.in.entities.PostEntity;
import com.joaopd.blog.application.core.domain.Post;
import com.joaopd.blog.application.core.dto.CommentDTO;
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
        this.repository.create(new PostEntity(p));
    }

    @Override
    public void updatePost(Post p) {
        this.repository.update(new PostEntity(p));
    }

    @Override
    public void commentPost(String postId, CommentDTO dto) {
        Post post = findPostById(postId);
        post.addComment(dto);

        updatePost(post);
    }
}
