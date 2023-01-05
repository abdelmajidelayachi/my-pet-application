package com.example.mypet.payload.dao;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class ResponseResponse {
    private Long id;
    private String message;
    private Long commentId;
    private Long userId;
}
