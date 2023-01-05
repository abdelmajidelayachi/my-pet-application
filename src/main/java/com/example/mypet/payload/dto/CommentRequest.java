package com.example.mypet.payload.dto;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class CommentRequest {
    
    private String comment;
    private Long postId;
}
