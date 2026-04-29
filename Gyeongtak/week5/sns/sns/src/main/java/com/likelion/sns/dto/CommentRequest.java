package com.likelion.sns.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "댓글 작성 요청 DTO")
@Getter
@Setter
public class CommentRequest {

    @Schema(description = "댓글 내용", example = "우왕 너무 신기해요 히히!")
    private String content;

    @Schema(description = "작성자 회원 번호", example = "1")
    private Integer userId;

    @Schema(description = "댓글이 달릴 게시글 번호", example = "1")
    private Integer postId;
}