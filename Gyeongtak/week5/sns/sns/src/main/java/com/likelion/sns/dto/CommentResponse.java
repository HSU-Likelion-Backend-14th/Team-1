package com.likelion.sns.dto;

import com.likelion.sns.entity.Comment;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.time.LocalDateTime;

@Schema(description = "댓글 응답 DTO")
@Getter
public class CommentResponse {

    @Schema(description = "생성된 댓글의 고유 ID", example = "5")
    private Integer commentId;

    @Schema(description = "댓글 내용", example = "너무 재미있어요!")
    private String content;

    @Schema(description = "작성 일시", example = "2024-05-20T15:30:00")
    private LocalDateTime createAt;

    @Schema(description = "작성자 닉네임", example = "고경탁")
    private String userName;

    public CommentResponse(Comment comment){
        this.commentId = comment.getCommentId();
        this.content = comment.getContent();
        this.createAt = comment.getCreateAt();
        this.userName = comment.getUser().getNickname();
    }
}