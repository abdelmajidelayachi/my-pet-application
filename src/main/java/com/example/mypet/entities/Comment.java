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

    @OneToMany(mappedBy = "comment", fetch = FetchType.LAZY)
    private Set<Response> responses;

    @JoinColumn(name = "offer_id",insertable = false,updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Offer offer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    private User user;


}
