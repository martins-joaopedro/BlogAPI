package com.joaopd.blog.application.core.domain;

import com.joaopd.blog.application.core.dto.CommentDTO;

public class Comment {

    String id;
    String authorId;
    String text;

    public Comment(String id, String authorId, String text) {
        this.id = id;
        this.authorId = authorId;
        this.text = text;
    }

    public Comment(CommentDTO dto) {
        this.authorId = dto.authorId();
        this.text = dto.text();
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
}
