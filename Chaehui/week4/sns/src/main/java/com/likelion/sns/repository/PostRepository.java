package com.likelion.sns.repository;

import com.likelion.sns.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    // 특정 키워드를 포함한 게시글을 검색하는 메소드
    // 반환 : List<Post>
    // 힌트 : @Query + LIKE
    @Query("SELECT p FROM Post p WHERE p.content LIKE %:keyword%")
    List<Post> findByContentContaining(@Param("keyword") String keyword);

    // 특정 사용자가 작성한 게시글 중 최신 5개만 조회하는 메소드
    // 반환 : List<Post>
    // 힌트 : findTop5+OrderBy
    List<Post> findTop5UserIdOrderByCreatedAtDesc(Integer userId);

    // 조회수가 많은 순서대로 정렬하여 게시글 조회
    // 반환 : List<Post>
    // 힌트 : OrderBy + Desc


    List<Post> findAllByOrderByViewCountDesc();

}
