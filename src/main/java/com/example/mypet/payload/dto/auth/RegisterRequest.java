package com.example.mypet.payload.dto.auth;

import lombok.*;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String confirmPassword;
    private String username;
    private String phone;
    private String adoptedPets;
    private int numberOfPets;
}
