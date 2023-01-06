package com.example.mypet.payload.dao;

import com.example.mypet.payload.dto.CommentRequest;
import lombok.*;

import java.util.List;

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
    private List<CommentRequest> comments;

}
