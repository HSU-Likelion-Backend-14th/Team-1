package com.likelion.sns.service;

import com.likelion.sns.entity.Comment;
import com.likelion.sns.entity.Post;
import com.likelion.sns.repository.CommentRepository;
import com.likelion.sns.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    // 1. 목록 조회
    public List<Comment> getCommentsByPost(Integer postId) {
        if (!postRepository.existsById(postId)) {
            throw new RuntimeException("Post not found");
        }
        return commentRepository.findByPostId(postId);
    }

    // 2. 상세 조회 (이게 없으면 컨트롤러에서 에러가 납니다)
    public Comment getComment(Integer commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
    }

    // 3. 작성 (생성자 없이 Setter 사용)
    @Transactional
    public Comment createComment(Integer postId, String content) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        Comment comment = new Comment(); // 빈 객체 생성
        comment.setContent(content);     // Setter 활용
        comment.setPost(post);

        return commentRepository.save(comment);
    }
}