package com.example.mypet.controllers;

import com.example.mypet.payload.dto.OfferRequest;
import com.example.mypet.provider.CloudinaryProvider;
import com.example.mypet.services.ImagesRequest;
import com.example.mypet.services.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final OfferService postService;
    private final CloudinaryProvider cloudinaryProvider;


    @GetMapping
    public ResponseEntity<Map<String, Object>> findAllPosts(){
        return ResponseEntity.ok().body(Map.of("status", "success", "data", postService.findAllPosts()));
    }

    @GetMapping("{id}")
    public ResponseEntity<Map<String, Object>> findPostById(@PathVariable Long id){
        return ResponseEntity.ok().body(Map.of("status", "success", "data", postService.findPost(id)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> uploadPost(@ModelAttribute ImagesRequest imagesRequest){
        String url = cloudinaryProvider.uploadImage(imagesRequest.getImage());
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(url);
    }
    @PostMapping
    public ResponseEntity<Map<String, Object>> createPost(@RequestBody OfferRequest postRequest){
        return ResponseEntity.ok().body(Map.of("status", "success", "data", postService.savePost(postRequest)));
    }

    @PutMapping("{id}")
    public ResponseEntity<Map<String, Object>> updatePost(@PathVariable Long id, @RequestBody OfferRequest postRequest){
        return ResponseEntity.ok().body(Map.of("status", "success", "data", postService.updatePost(id, postRequest)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, Object>> deletePost(@PathVariable Long id){
        return ResponseEntity.ok().body(Map.of("status", "success", "data", "Post deleted successfully"));
    }

}


