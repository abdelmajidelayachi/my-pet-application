package com.example.mypet.payload.dao;

import lombok.*;

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
}
