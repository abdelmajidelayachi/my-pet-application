package com.example.mypet.controllers;

import com.example.mypet.payload.dao.UserResponse;
import com.example.mypet.payload.dto.UserRequest;
import com.example.mypet.repositories.UserRepository;
import com.example.mypet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * @return List of all users
     */
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllUsers() {
        return ResponseEntity.ok().body(Map.of("status", "success", "data", userService.findAllUser()));
    }

    @GetMapping("/test")
    public ResponseEntity<Map<String, Object>> test() {
        return ResponseEntity.ok().body(Map.of("status", "success", "data", "test"));
    }
    @PostMapping
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok().body(Map.of("status", "success", "data", userService.saveUser(userRequest)));
    }

}
