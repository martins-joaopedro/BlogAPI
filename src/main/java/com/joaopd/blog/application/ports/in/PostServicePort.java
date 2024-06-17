package com.joaopd.blog.application.ports.in;

import java.util.List;

import com.joaopd.blog.adapter.in.entities.PostEntity;
import com.joaopd.blog.application.core.domain.Post;
import com.joaopd.blog.application.core.dto.CommentDTO;
import com.joaopd.blog.application.core.dto.PostDTO;

public interface PostServicePort {
    
    public List<Post> findAllPosts();

    Post findPostById(String id);

    void savePost(PostDTO p);

    void updatePost(Post p);

    void commentPost(String postId, CommentDTO dto);
}
