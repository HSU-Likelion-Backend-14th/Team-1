package com.likelion.sns.controller;

import com.likelion.sns.dto.CommentRequest;
import com.likelion.sns.dto.CommentResponse;
import com.likelion.sns.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts/{postId}/comments")
@RequiredArgsConstructor
@Tag(name = "댓글 API", description = "게시글에 달린 댓글을 조회하고 작성합니다")
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    @Operation(summary = "특정 게시글의 댓글 목록 조회",
            description = "postId에 해당하는 게시글의 전체 댓글을 반환합니다. 게시글이 없으면 404, 댓글이 없으면 빈 배열을 반환합니다.")
    public ResponseEntity<List<CommentResponse>> getComments(
            @Parameter(description = "게시글 ID") @PathVariable Integer postId) {
        return ResponseEntity.ok(commentService.getComments(postId));
    }

    @GetMapping("/{commentId}")
    @Operation(summary = "댓글 단건 상세 조회",
            description = "postId와 commentId에 해당하는 댓글 하나를 반환합니다. 게시글 또는 댓글이 없으면 404를 반환합니다.")
    public ResponseEntity<CommentResponse> getComment(
            @Parameter(description = "게시글 ID") @PathVariable Integer postId,
            @Parameter(description = "댓글 ID") @PathVariable Integer commentId) {
        return ResponseEntity.ok(commentService.getComment(postId, commentId));
    }

    @PostMapping
    @Operation(summary = "댓글 작성",
            description = "postId에 해당하는 게시글에 댓글을 작성합니다. content가 비어있으면 400, 게시글이 없으면 404를 반환합니다.")
    public ResponseEntity<CommentResponse> createComment(
            @Parameter(description = "게시글 ID") @PathVariable Integer postId,
            @RequestBody CommentRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.createComment(postId, request));
    }
}