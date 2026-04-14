package com.likelion.sns.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name="login_id",nullable=false,unique=true,length=50)
    private String loginId;

    @Column(nullable=false,length=50)
    private String password;
    // 비워둘 수 없기 때문에 nullable=false

    @Column(unique=true,length=50)
    private String nickname;

    @Column(name="created_at",updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

}
