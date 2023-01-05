package com.example.mypet.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "animals")
@Builder
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Animal {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "description", length = 50)
    private String description;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "user_id")
    private Long userId;

    @OneToMany(mappedBy = "animal")
    private Set<Image> images;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

}
