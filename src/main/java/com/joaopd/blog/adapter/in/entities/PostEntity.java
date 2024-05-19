package com.joaopd.blog.adapter.in.entities;
import com.joaopd.blog.application.core.domain.Post;
import com.joaopd.blog.application.core.dto.PostDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "posts")
public class PostEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String authorId;
    private String text;

    PostEntity() {}

    public PostEntity(PostDTO post) {
        this.authorId = post.getAuthorId();
        this.text = post.getText();
    }

    public Post toPost() {
        return new Post(id, authorId, text);
    }
}
