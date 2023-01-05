package com.example.mypet.repositories;

import com.example.mypet.entities.Animal;
import lombok.Builder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository  extends CrudRepository<Animal, Long> {
    //
}
