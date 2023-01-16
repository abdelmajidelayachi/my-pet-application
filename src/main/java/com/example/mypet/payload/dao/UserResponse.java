package com.example.mypet.payload.dao;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class UserResponse {

    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String phone;
    private String adoptedPets;
    private int numberOfPets;
    private String avatar;
    private List<OfferResponse> post;
}
