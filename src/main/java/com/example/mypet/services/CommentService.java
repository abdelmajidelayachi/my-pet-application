package com.example.mypet.services;

import com.example.mypet.entities.Comment;
import com.example.mypet.payload.dao.CommentResponse;
import com.example.mypet.payload.dto.CommentRequest;
import com.example.mypet.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;

    public List<CommentResponse> findAllComments() {
        List<CommentResponse> commentResponses = new ArrayList<>();
        commentRepository.findAll().forEach(comment -> {
            commentResponses.add(CommentResponse.builder()
                    .id(comment.getId())
                    .comment(comment.getContent())
                    .build());
        });
        return commentResponses;
    }

    public CommentResponse saveComment(CommentRequest commentRequest) {
        if (commentRequest.getComment() == null || commentRequest.getPostId() == null) {
            throw new RuntimeException("Comment, postId and userId are required");
        }
        var comment = Comment.builder()
                .content(commentRequest.getComment())
                .postId(commentRequest.getPostId())
                .userId(userService.findUserByEmail().getId())
                .build();
        commentRepository.save(comment);
        return CommentResponse.builder()
                .id(comment.getId())
                .comment(comment.getContent())
                .postId(commentRequest.getPostId())
                .build();
    }

    public CommentResponse findCommentById(Long id) {
        if (id == null) {
            throw new RuntimeException("Id is required");
        }
        var comment = commentRepository.findById(id).orElseThrow(() -> new RuntimeException("Comment not found"));
        return CommentResponse.builder()
                .id(comment.getId())
                .comment(comment.getContent())
                .userId(comment.getUser().getId())
                .build();
    }


    @Transactional
    public CommentResponse updateComment(Long id, CommentRequest commentRequest) {
        if (id == null) {
            throw new RuntimeException("Id is required");
        }
        var comment = commentRepository.findById(id).orElseThrow(() -> new RuntimeException("Comment not found"));
        if (commentRequest.getComment() != null) {
            comment.setContent(commentRequest.getComment());
        }
        comment.setContent(commentRequest.getComment());
        return CommentResponse.builder()
                .id(comment.getId())
                .comment(comment.getContent())
                .postId(comment.getPost().getId())
                .userId(comment.getUser().getId())
                .build();
    }

    public void deleteComment(Long id) {
        if (id == null) {
            throw new RuntimeException("Id is required");
        }
        var comment = commentRepository.findById(id).orElseThrow(() -> new RuntimeException("Comment not found"));
        commentRepository.delete(comment);
    }
}
