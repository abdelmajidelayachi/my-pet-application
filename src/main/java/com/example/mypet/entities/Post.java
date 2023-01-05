package com.example.mypet.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@Entity
@Table(name = "posts")
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Post {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "description", length = 50)
    private String description;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name="days", length = 3)
    private int days;

    @Column(name="price", length = 5)
    private float price;

    @Column(name="city", length = 50)
    private String city;

    @Column(name = "animal_id")
    private Long animalId;

    @Column(name="user_id")
    private Long userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "animal_id" , insertable = false, updatable = false)
    private Animal animal;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private User user;




}
