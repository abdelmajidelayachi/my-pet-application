package com.example.mypet.payload.dao;

import lombok.*;

import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class CommentResponse {
        private Long id;
        private String comment;
        private Long postId;
        private Long userId;
        private List<ResponseResponse> responses;
}
