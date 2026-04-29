package com.likelion.sns.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "posts_file")
@Getter
@Setter
public class PostsFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fileId;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false)
    private Long size;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp //@Colunm 옵션에 columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP" 추가
    private LocalDateTime createdAt;

    @Column(name = "file_url", nullable = false, length = 500)
    private String fileUrl;

    @Column(name = "download_count")
    private Integer downloadCount = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;


}
