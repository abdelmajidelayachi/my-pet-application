package com.example.mypet.entities;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "images")
public class Image {
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "url", length = 255)
    private String url;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "offer_id")
    private Offer offer;

}
