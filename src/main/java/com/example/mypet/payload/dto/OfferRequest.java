package com.example.mypet.payload.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class PostRequest {
    private String city;
    private int days;
    private String animal_description;
    private String offer_description;
    private float price;
    private String animal_type;
    private String contact;
    private String title;
    private List<String> images;
}
