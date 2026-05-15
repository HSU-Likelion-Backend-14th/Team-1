package com.likelion.sns.Repository;

import com.likelion.sns.entity.Comment;
import com.likelion.sns.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByPost_PostId(Integer postId);

}
