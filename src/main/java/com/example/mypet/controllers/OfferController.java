package com.example.mypet.controllers;

import com.example.mypet.payload.dto.OfferRequest;
import com.example.mypet.provider.CloudinaryProvider;
import com.example.mypet.services.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class OfferController {

    private final OfferService offerService;
    private final CloudinaryProvider cloudinaryProvider;


    @GetMapping
    public ResponseEntity<Map<String, Object>> findAllOffers() {
        return ResponseEntity.ok().body(Map.of("status", "success", "data", offerService.findAllOffers()));
    }

    @GetMapping("{id}")
    public ResponseEntity<Map<String, Object>> findOfferById(@PathVariable Long id) {
        return ResponseEntity.ok().body(Map.of("status", "success", "data", offerService.findOffer(id)));
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Map<String, Object>> createOffer(@ModelAttribute OfferRequest offerRequest) {
        System.out.println(offerRequest);
        return ResponseEntity.ok().body(Map.of("status", "success", "data", offerService.saveOffer(offerRequest)));
    }

    @PutMapping("{id}")
    public ResponseEntity<Map<String, Object>> updateOffer(@PathVariable Long id, @RequestBody OfferRequest offerRequest) {
        return ResponseEntity.ok().body(Map.of("status", "success", "data", offerService.updateOffer(id, offerRequest)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, Object>> deleteOffer(@PathVariable Long id) {
        return ResponseEntity.ok().body(Map.of("status", "success", "data", "Offer deleted successfully"));
    }

}


