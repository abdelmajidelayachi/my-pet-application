package com.example.mypet.payload.dao;

import com.example.mypet.entities.Image;
import com.example.mypet.payload.dto.CommentRequest;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class OfferResponse {

    private Long id;
    private String city;
    private int days;
    private String animal_description;
    private String offer_description;
    private float price;
    private String animal_type;
    private String contact;
    private String title;
    private UserResponse user;
    private Set<ImageResponse> images;

}
