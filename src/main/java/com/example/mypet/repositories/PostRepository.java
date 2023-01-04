package com.example.mypet.repositories;

import com.example.mypet.entities.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
    //
}
