package com.likelion.sns.dto;

import com.likelion.sns.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponse {
    private final Integer id;
    private final String content;
    private final Integer userId;
    private final LocalDateTime createdAt;

    public CommentResponse(Comment comment) {
        this.id = comment.getCommentId();
        this.content = comment.getContent();
        this.userId = comment.getUser() != null ? comment.getUser().getUserId() : null;
        this.createdAt = comment.getCreatedAt();
    }
}