package com.example.mypet.controllers;

import com.example.mypet.payload.dao.AuthResponse;
import com.example.mypet.payload.dto.auth.LoginRequest;
import com.example.mypet.payload.dto.auth.RegisterRequest;
import com.example.mypet.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest registerRequest){
        return ResponseEntity.ok(authService.register(registerRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest registerRequest){
        return ResponseEntity.ok(authService.login(registerRequest));
    }

}
