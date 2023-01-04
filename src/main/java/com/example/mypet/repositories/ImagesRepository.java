package com.example.mypet.repositories;

import com.example.mypet.entities.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagesRepository extends CrudRepository<Image, Long> {
    //
}
