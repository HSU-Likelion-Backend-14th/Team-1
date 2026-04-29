package com.likelion.sns.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.w3c.dom.Text;

import java.time.LocalTime;

@Entity
@Table(name = "Comments")
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT") // 컬럼 정의를 TEXT
    private String content;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalTime createAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
