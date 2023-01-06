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
    private String description;
    private float price;
    private String type;

}
