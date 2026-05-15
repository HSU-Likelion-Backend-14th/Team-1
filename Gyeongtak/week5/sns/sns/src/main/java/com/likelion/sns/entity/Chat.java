package com.likelion.sns.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "chat")
@Getter
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long chatId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "send_at", updatable = false)
    @CreationTimestamp //@Colunm 옵션에 columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP" 추가
    private LocalDateTime sendAt;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private ChatRoom chatRoom;
}
