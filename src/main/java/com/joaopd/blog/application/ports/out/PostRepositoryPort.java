package com.joaopd.blog.application.ports.out;

import java.util.List;

import com.joaopd.blog.adapter.in.entities.PostEntity;
import com.joaopd.blog.application.core.domain.Post;

public interface PostRepositoryPort {

    void create(PostEntity p);

    List<Post> findAll();

    Post findById(String id);

}
