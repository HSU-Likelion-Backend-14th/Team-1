package com.likelion.sns.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "게시글 API", description = "게시글 CRUD")
@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class UserController {

//    @Operation(
//            summary = "게시글 목록 조회",
//            description = "게시글 목록을 조회한다."
//    )
//    @ApiResponse({
//            @ApiResponse(
//                    responseCode = "200",
//                    description = "조회 성공"
//            )
//    })
//    @GetMapping

}
