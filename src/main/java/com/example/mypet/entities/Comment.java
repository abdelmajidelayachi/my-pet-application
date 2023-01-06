package com.example.mypet.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "comments")
@Setter
@Builder
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class Comment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "content", length = 400)
    private String content;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "post_id")
    private Long postId;

    @OneToMany(mappedBy = "comment", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Response> responses;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id",insertable = false,updatable = false)
    private Post post;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    private User user;


}
