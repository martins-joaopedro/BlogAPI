package com.joaopd.blog.application.core.dto;

import com.joaopd.blog.application.core.domain.Comment;

import java.util.List;

public record PostDTO(
        String id,
        String authorId,
        String text,
        List<Comment> comments
) {}
