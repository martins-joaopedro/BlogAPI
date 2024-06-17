package com.joaopd.blog.adapter.in.entities;
import com.joaopd.blog.application.core.domain.Comment;
import com.joaopd.blog.application.core.domain.Post;
import com.joaopd.blog.application.core.dto.PostDTO;

import jakarta.persistence.*;
import org.springframework.data.repository.cdi.Eager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "posts")
public class PostEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String authorId;

    private String text;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CommentEntity> comments;

    public PostEntity(PostDTO dto) {
        this.authorId = dto.authorId();
        this.text = dto.text();
    }

    public PostEntity(Post p) {
        this.id = p.getId();
        this.text = p.getText();
        this.authorId = p.getAuthorId();
        this.comments = p.getComments().stream().map(Comment::toEntity).collect(Collectors.toList());
    }

    public PostEntity() { };

    public Post toPost() {
        List<Comment> p = new ArrayList<>();
        p.addAll(getComments());
        return new Post(id, authorId, text, p);
    }

    public List<Comment> getComments() {
        return comments
                .stream()
                .map(CommentEntity::toComment)
                .collect(Collectors.toList());
    }

}
