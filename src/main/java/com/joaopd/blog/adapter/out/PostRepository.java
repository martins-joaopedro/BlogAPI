package com.joaopd.blog.adapter.out;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.joaopd.blog.adapter.in.entities.PostEntity;
import com.joaopd.blog.adapter.out.repositories.PostSpringRepository;
import com.joaopd.blog.application.core.domain.Post;
import com.joaopd.blog.application.ports.out.PostRepositoryPort;

@Component
public class PostRepository implements PostRepositoryPort {
    
    private final PostSpringRepository repository;

    PostRepository(PostSpringRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(PostEntity p) {
        this.repository.save(p);
    }

    @Override
    public List<Post> findAll() {
        List<PostEntity> posts = this.repository.findAll(); 
        return posts
                .stream()
                .map(PostEntity::toPost)
                .collect(Collectors.toList());
    }

    @Override
    public Post findById(String id) {

        Optional<PostEntity> post = this.repository.findById(id);

        if(post.isPresent())
            return post.get().toPost();
        else return null;
    }
        
}
