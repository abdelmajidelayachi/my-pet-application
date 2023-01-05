package com.example.mypet.controllers;

import com.example.mypet.payload.dto.PostRequest;
import com.example.mypet.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> findAllPosts(){
        return ResponseEntity.ok().body(Map.of("status", "success", "data", postService.findAllPosts()));
    }

    @GetMapping("{id}")
    public ResponseEntity<Map<String, Object>> findPostById(@PathVariable Long id){
        return ResponseEntity.ok().body(Map.of("status", "success", "data", postService.findPost(id)));
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createPost(@RequestBody PostRequest postRequest){
        return ResponseEntity.ok().body(Map.of("status", "success", "data", postService.savePost(postRequest)));
    }

    @PutMapping("{id}")
    public ResponseEntity<Map<String, Object>> updatePost(@PathVariable Long id, @RequestBody PostRequest postRequest){
        return ResponseEntity.ok().body(Map.of("status", "success", "data", postService.updatePost(id, postRequest)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, Object>> deletePost(@PathVariable Long id){
        return ResponseEntity.ok().body(Map.of("status", "success", "data", "Post deleted successfully"));
    }

}


