package com.example.mypet.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "responses")
@Getter
@Builder
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Response {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "comment_id")
    private Long commentId;

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id",insertable = false,updatable = false)
    private Comment comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    private User user;
}
