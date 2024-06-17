package com.joaopd.blog.application.core.domain;

import com.joaopd.blog.adapter.in.entities.PostEntity;
import com.joaopd.blog.application.core.dto.CommentDTO;
import com.joaopd.blog.application.core.dto.PostDTO;

import java.util.ArrayList;
import java.util.List;

public class Post {

    String id;
    String authorId;
    String text;

    List<Comment> comments = new ArrayList<>();

    public Post(String id, String authorId, String text, List<Comment> c) {
        this.id = id;
        this.authorId = authorId;
        this.text = text;
        this.comments.addAll(c);
    }

    public Post(PostDTO dto) {
        this.authorId = dto.authorId();
        this.text = dto.text();
    }

    public void addComment(CommentDTO dto) {

        Comment newComment = new Comment(dto);
        this.comments.add(newComment);
    }

    public PostDTO toDTO() {
        return new PostDTO(id, authorId, text, comments);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
