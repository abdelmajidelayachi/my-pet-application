package com.example.mypet.payload.dao;

import lombok.*;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class PostResponse {

    private Long id;
    private String city;
    private int days;
    private String description;
    private float price;
    private String type;

}
