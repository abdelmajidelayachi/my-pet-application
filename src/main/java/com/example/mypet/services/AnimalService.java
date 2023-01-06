package com.example.mypet.services;

import com.example.mypet.entities.Animal;
import com.example.mypet.entities.User;
import com.example.mypet.payload.dao.AnimalResponse;
import com.example.mypet.payload.dto.AnimalRequest;
import com.example.mypet.repositories.AnimalRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Builder
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final UserService userService;


    public List<AnimalResponse> findAllAnimals() {
        List<AnimalResponse> animalResponses = new ArrayList<>();
        animalRepository.findAll().forEach(animal -> {
            animalResponses.add(AnimalResponse.builder()
                    .id(animal.getId())
                    .description(animal.getDescription())
                    .type(animal.getType())
                    .build());
        });
        return animalResponses;
    }

    public AnimalResponse saveAnimal(AnimalRequest request) {
        if(request.getDescription() == null || request.getType() == null){
            throw new RuntimeException("Description and type are required");
        }
        // get user id from token
        User user = userService.findUserByEmail();
        var animal = Animal.builder()
                .userId(user.getId())
                .description(request.getDescription())
                .type(request.getType())
                .build();
        animalRepository.save(animal);
        return AnimalResponse.builder()
                .id(animal.getId())
                .description(animal.getDescription())
                .type(animal.getType())
                .build();
    }

    public AnimalResponse findAnimalById(Long id) {
        if(id == null){
            throw new RuntimeException("Id is required");
        }
        var animal = animalRepository.findById(id).orElseThrow(() -> new RuntimeException("Animal not found"));
        return AnimalResponse.builder()
                .id(animal.getId())
                .description(animal.getDescription())
                .type(animal.getType())
                .build();
    }

    @Transactional
    public AnimalResponse updateAnimal(Long id, AnimalRequest request) {
        if(id == null){
            throw new RuntimeException("Id is required");
        }
        var animal = animalRepository.findById(id).orElseThrow(() -> new RuntimeException("Animal not found"));
        if(request.getDescription() != null){
            animal.setDescription(request.getDescription());
        }
        if(request.getType() != null){
            animal.setType(request.getType());
        }
        return AnimalResponse.builder()
                .id(animal.getId())
                .description(animal.getDescription())
                .type(animal.getType())
                .build();
    }

    public void deleteAnimal(Long id) {
        if(id == null){
            throw new RuntimeException("Id is required");
        }
        var animal = animalRepository.existsById(id);
        if(!animal){
            throw new RuntimeException("Animal not found");
        }
        animalRepository.deleteById(id);
    }
}
