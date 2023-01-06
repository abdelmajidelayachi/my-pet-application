package com.example.mypet.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "images")
public class Image {
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    @Lob
    @Column(name = "content", length = 100000)
    private byte[] content;

    @Column(name = "animal_id")
    private Long animalId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "animal_id",  updatable = false, insertable = false)
    private Animal animal;

}
