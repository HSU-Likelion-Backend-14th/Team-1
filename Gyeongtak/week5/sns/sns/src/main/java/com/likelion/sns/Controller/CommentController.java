package com.likelion.sns.Controller;

import com.likelion.sns.dto.CommentRequest;
import com.likelion.sns.dto.CommentResponse;
import com.likelion.sns.entity.Comment;
import com.likelion.sns.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// 1. @Tag: 컨트롤러 단위의 그룹화 및 설명
@Tag(name = "댓글 API", description = "댓글 조회 및 작성 기능을 제공합니다.")
@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // 2. @Operation: 각 API 메서드에 대한 요약과 상세 설명
    @Operation(summary = "게시글 댓글 목록 조회", description = "특정 게시글 ID를 기반으로 해당 게시글에 달린 모든 댓글을 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "조회 성공")
    })
    @GetMapping("/post/{postId}")
    public List<Comment> getCommentlist(
            // 3. @Parameter: 경로 변수(Path Variable)나 쿼리 파라미터 설명
            @Parameter(description = "조회할 게시글 ID", example = "1")
            @PathVariable("postId") Integer postId){
        return commentService.getCommentList(postId);
    }

    @Operation(summary = "단일 댓글 상세 조회", description = "댓글 ID를 기반으로 특정 댓글 1건의 상세 정보를 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "404", description = "댓글을 찾을 수 없습니다")
    })
    @GetMapping("/{id}")
    public Optional<Comment> getComment(
            @Parameter(description = "조회할 댓글 ID", example = "1")
            @PathVariable("id") Integer Id){
        return commentService.getComment(Id);
    }

    @Operation(summary = "댓글 작성", description = "본문(JSON) 정보를 전달받아 새로운 댓글을 등록합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "작성 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 (예: 존재하지 않는 유저나 게시글)")
    })
    @PostMapping
    public CommentResponse createComment(
            @Parameter(description = "댓글 생성 필수 데이터")
            @RequestBody CommentRequest request){
        return commentService.createComment(request);
    }
}