package com.likelion.sns.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "chat_room")
@Getter
@Setter
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomId;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false)
    private Integer member;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp //@Colunm 옵션에 columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP" 추가
    private LocalDateTime createdAt;

    @Column(name = "update_at", updatable = true)
    @CreationTimestamp
    private LocalDateTime updateAt;
}
