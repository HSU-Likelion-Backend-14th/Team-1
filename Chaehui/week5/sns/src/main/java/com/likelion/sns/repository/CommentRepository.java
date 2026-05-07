package com.likelion.sns.repository;

import com.likelion.sns.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    // c.post(Comment 내 필드)의 .postId(Post 내 필드)를 조회하도록 명시합니다.
    @Query("SELECT c FROM Comment c WHERE c.post.postId = :postId")
    List<Comment> findByPostId(@Param("postId") Integer postId);
}