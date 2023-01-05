package com.example.mypet.payload.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ResponseRequest {

        private String message;
        private Long commentId;
        private Long userId;

}
