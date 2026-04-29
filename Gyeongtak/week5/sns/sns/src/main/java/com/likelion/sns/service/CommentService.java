package com.likelion.sns.service;

import com.likelion.sns.Repository.CommentRepository;
import com.likelion.sns.Repository.PostRepository;
import com.likelion.sns.Repository.UserRepository;
import com.likelion.sns.dto.CommentRequest;
import com.likelion.sns.dto.CommentResponse;
import com.likelion.sns.entity.Comment;
import com.likelion.sns.entity.Post;
import com.likelion.sns.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.metadata.PostgresCallMetaDataProvider;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Comment>getCommentList(Integer postId){
        return commentRepository.findByPost_PostId(postId);
    }

    public Optional<Comment> getComment(Integer Id){
        return commentRepository.findById(Id);
    }

    public CommentResponse createComment(CommentRequest request){
        Post post = postRepository.findById(request.getPostId())
                .orElseThrow(()->new IllegalArgumentException("게시글을 찾을 수 없습니다."));
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(()->new IllegalArgumentException("유저를 찾을 수 없습니다."));
        Comment comment = new Comment();
        comment.setContent(request.getContent());
        comment.setPost(post);
        comment.setUser(user);

        Comment saved = commentRepository.save(comment);

        return new CommentResponse(saved);
    }

}
