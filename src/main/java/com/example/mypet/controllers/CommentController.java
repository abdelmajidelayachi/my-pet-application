package com.example.mypet.controllers;

import com.example.mypet.payload.dto.CommentRequest;
import com.example.mypet.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllComments(){
        return ResponseEntity.status(200).body(Map.of("status", "success", "data", commentService.findAllComments()));
    }

    @GetMapping("{id}")
    public ResponseEntity<Map<String, Object>> getCommentById(@PathVariable Long id){
        return ResponseEntity.status(200).body(Map.of("status", "success", "data", commentService.findCommentById(id)));
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createComment(@RequestBody CommentRequest commentRequest){
        return ResponseEntity.status(201).body(Map.of("status", "success", "data", commentService.saveComment(commentRequest)));
    }

    @PutMapping("{id}")
    public ResponseEntity<Map<String, Object>> updateComment(@PathVariable Long id, @RequestBody CommentRequest commentRequest){
        return ResponseEntity.status(200).body(Map.of("status", "success", "data", commentService.updateComment(id, commentRequest)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, Object>> deleteComment(@PathVariable Long id){
        commentService.deleteComment(id);
        return ResponseEntity.status(200).body(Map.of("status", "success", "data", "Comment deleted successfully"));
    }

}
