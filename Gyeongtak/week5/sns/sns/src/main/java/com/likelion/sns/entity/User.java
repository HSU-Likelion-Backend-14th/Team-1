package com.likelion.sns.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "login_id", nullable = false, unique = true, length = 50)
    private String loginId;

    @Column(nullable = false, length = 50)
    private String password;

    @Column(unique = true, length = 100)
    private String nickname;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp //@Colunm 옵션에 columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP" 추가
    private LocalDateTime createdAt;


}
