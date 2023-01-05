package com.example.mypet.controllers;

import com.example.mypet.entities.Animal;
import com.example.mypet.payload.dto.AnimalRequest;
import com.example.mypet.services.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/animal")
@RequiredArgsConstructor
public class AnimalController {

    private final AnimalService animalService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllAnimals(){
        return ResponseEntity.ok().body(Map.of("status", "success", "data", animalService.findAllAnimals()));
    }

    @GetMapping("{id}")
    public ResponseEntity<Map<String, Object>> getAnimalById(@PathVariable Long id){
        return ResponseEntity.ok().body(Map.of("status", "success", "data", animalService.findAnimalById(id)));
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createAnimal(@RequestBody AnimalRequest animalRequest){
        return ResponseEntity.ok().body(Map.of("status", "success", "data", animalService.saveAnimal(animalRequest)));
    }




}
