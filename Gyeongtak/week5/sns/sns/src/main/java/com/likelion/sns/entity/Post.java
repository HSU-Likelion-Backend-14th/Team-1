package com.likelion.sns.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "Post")
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "view_count")
    private Integer viewCount = 0;

    @Column(name = "create_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createAt;

    @ManyToOne(fetch = FetchType.LAZY) // 지연 로딩
    @JoinColumn(name = "User_id")
    private User user;
}
