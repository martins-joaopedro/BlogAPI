package com.joaopd.blog.adapter.in.entities;

import com.joaopd.blog.application.core.domain.Comment;
import com.joaopd.blog.application.core.dto.CommentDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;

    String authorId;

    @Column(length = 255)
    String text;

    CommentEntity(CommentDTO dto) {
        this.authorId = dto.authorId();
        this.text = dto.text();
    }

    public CommentEntity() {

    }

    public Comment toComment() {
        return new Comment(id, authorId, text);
    }

}
