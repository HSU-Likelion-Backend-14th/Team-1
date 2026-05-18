package com.likelion.sns.repository;

import com.likelion.sns.entity.Post;
import com.likelion.sns.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    // 특정 키워드를 포함한 게시글 검색
    List<Post> findByContentContaining(String keyword);

    // 특정 사용자가 작성한 게시글 중 최신 5개
    List<Post> findTop5ByUserOrderByCreatedAtDesc(User user);

    // 조회수 내림차순 정렬
    List<Post> findAllByOrderByViewCountDesc();
}