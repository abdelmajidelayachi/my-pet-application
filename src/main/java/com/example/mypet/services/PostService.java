package com.example.mypet.services;


import com.example.mypet.entities.Post;
import com.example.mypet.payload.dao.PostResponse;
import com.example.mypet.payload.dto.PostRequest;
import com.example.mypet.repositories.PostRepository;
import com.example.mypet.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserService userService;

    public List<PostResponse> findAllPosts() {
        List<PostResponse> posts = new ArrayList<>();

        postRepository.findAll().forEach(
                post -> posts.add(PostResponse.builder()
                        .id(post.getId())
                        .city(post.getCity())
                        .days(post.getDays())
                        .description(post.getDescription())
                        .price(post.getPrice())
                        .type(post.getType())
                        .build())
        );
        return posts;
    }

    public PostResponse findPost(Long id) {
        if (id == null) {
            throw new RuntimeException("Id is required");
        }
        var post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        return PostResponse.builder()
                .id(post.getId())
                .city(post.getCity())
                .days(post.getDays())
                .description(post.getDescription())
                .price(post.getPrice())
                .type(post.getType())
                .build();
    }

    public PostResponse savePost(PostRequest postRequest) {
        if (postRequest.getCity() == null || postRequest.getDescription() == null || postRequest.getType() == null) {
            throw new RuntimeException("All fields are required");
        }
        var post = Post.builder()
                .userId(userService.findUserByEmail().getId())
                .city(postRequest.getCity())
                .days(postRequest.getDays())
                .description(postRequest.getDescription())
                .price(postRequest.getPrice())
                .type(postRequest.getType())
                .build();
        postRepository.save(post);
        return PostResponse.builder()
                .id(post.getId())
                .city(post.getCity())
                .days(post.getDays())
                .description(post.getDescription())
                .price(post.getPrice())
                .type(post.getType())
                .build();
    }

    public PostResponse updatePost(Long id, PostRequest postRequest) {
        if (id == null) {
            throw new RuntimeException("Id is required");
        }
        var post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        post.setCity(postRequest.getCity());
        post.setDays(postRequest.getDays());
        post.setDescription(postRequest.getDescription());
        post.setPrice(postRequest.getPrice());
        post.setType(postRequest.getType());
        postRepository.save(post);
        return PostResponse.builder()
                .id(post.getId())
                .city(post.getCity())
                .days(post.getDays())
                .description(post.getDescription())
                .price(post.getPrice())
                .type(post.getType())
                .build();
    }

    public void deletePost(Long id) {
        if (id == null) {
            throw new RuntimeException("Id is required");
        }
        var post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        postRepository.delete(post);
    }
}
