package com.likelion.sns.controller;

import com.likelion.sns.dto.CommentResponse;
import com.likelion.sns.entity.Comment;
import com.likelion.sns.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    // 1. 특정 게시글의 댓글 목록 조회
    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<List<Comment>> readAll(@PathVariable Integer postId) {
        try {
            return ResponseEntity.ok(commentService.getCommentsByPost(postId));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // 2. 댓글 하나 상세 조회
    @GetMapping("/comments/{commentId}")
    public ResponseEntity<Comment> readOne(@PathVariable Integer commentId) {
        try {
            return ResponseEntity.ok(commentService.getComment(commentId));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // 3. 댓글 작성
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<Comment> create(
            @PathVariable Integer postId,
            @RequestBody CommentResponse dto) {
        try {
            Comment comment = commentService.createComment(postId, dto.getContent());
            return ResponseEntity.status(HttpStatus.CREATED).body(comment);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}