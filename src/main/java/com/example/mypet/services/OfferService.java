package com.example.mypet.services;


import com.example.mypet.entities.Image;
import com.example.mypet.entities.Offer;
import com.example.mypet.exceptions.ResourceNotFoundException;
import com.example.mypet.payload.dao.ImageResponse;
import com.example.mypet.payload.dao.OfferResponse;
import com.example.mypet.payload.dao.UserResponse;
import com.example.mypet.payload.dto.OfferRequest;
import com.example.mypet.provider.CloudinaryProvider;
import com.example.mypet.repositories.OfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OfferService {

    private final OfferRepository offerRepository;
    private final UserService userService;
    private final ImageService imageService;
    private final CloudinaryProvider cloudinaryProvider;

    public List<OfferResponse> findAllOffers() {
        List<OfferResponse> offers = new ArrayList<>();

        offerRepository.findAll().forEach(
                offer -> offers.add(OfferResponse.builder()
                        .id(offer.getId())
                        .city(offer.getCity())
                        .days(offer.getDays())
                        .offer_description(offer.getOfferDesc())
                        .animal_description(offer.getAnimalDesc())
                        .title(offer.getTitle())
                        .price(offer.getPrice())
                        .animal_type(offer.getAnimalType())
                        .contact(offer.getContact())
                        .images(offer.getImages().stream().map(image -> ImageResponse.builder().url(image.getUrl()).build()).collect(Collectors.toSet()))
                                .user(UserResponse.builder()
                                        .email(offer.getUser().getEmail())
                                        .username(offer.getUser().getUsername())
                                        .firstname(offer.getUser().getFirstname())
                                        .lastname(offer.getUser().getLastname())
                                        .avatar(offer.getUser().getAvatar())
                                        .build())
                        .build())
        );
        return offers;
    }

    public OfferResponse findOffer(Long id) {
        if (id == null) {
            throw new ResourceNotFoundException("Offer id is not provided"+id);
        }
        var offer = offerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Offer not found with id : "+ id));
        return OfferResponse.builder()
                .id(offer.getId())
                .city(offer.getCity())
                .days(offer.getDays())
                .offer_description(offer.getOfferDesc())
                .animal_description(offer.getAnimalDesc())
                .title(offer.getTitle())
                .price(offer.getPrice())
                .animal_type(offer.getAnimalType())
                .contact(offer.getContact())
                .images(offer.getImages().stream().map(image -> ImageResponse.builder().url(image.getUrl()).build()).collect(Collectors.toSet()))
                .build();
    }

    public OfferResponse saveOffer(OfferRequest offerRequest) {
        // validate offerRequest
        if (offerRequest.getOffer_description() == null) {
            throw new ResourceNotFoundException("offer description is not provided");
        }
        if (offerRequest.getAnimal_description() == null) {
            throw new ResourceNotFoundException("animal description is not provided");
        }
        if (offerRequest.getAnimal_type() == null) {
            throw new ResourceNotFoundException("animal type is not provided");
        }
        if (offerRequest.getCity() == null) {
            throw new ResourceNotFoundException("city is not provided");
        }
        if (offerRequest.getContact() == null) {
            throw new ResourceNotFoundException("contact is not provided");
        }
        if(offerRequest.getTitle() == null){
            throw new ResourceNotFoundException("title is not provided");
        }
        if(offerRequest.getImages() == null){
            throw new ResourceNotFoundException("images are not provided");
        }



        var offer = Offer.builder()
                .user(userService.findUserByEmail())
                .city(offerRequest.getCity())
                .days(offerRequest.getDays())
                .offerDesc(offerRequest.getOffer_description())
                .animalDesc(offerRequest.getAnimal_description())
                .title(offerRequest.getTitle())
                .price(offerRequest.getPrice())
                .animalType(offerRequest.getAnimal_type())
                .contact(offerRequest.getContact())
                .build();
        offerRepository.save(offer);
        Set<Image> images = imageService.uploadImages(offerRequest.getImages()).stream().map(image -> Image.builder()
                .url(image)
                .offer(offer)
                .build()).collect(Collectors.toSet());
        offer.setImages(images);
        offerRepository.save(offer);
        Set<ImageResponse> imageUrls = offer.getImages().stream().map(image -> ImageResponse.builder().url(image.getUrl()).build()).collect(Collectors.toSet());
        System.out.println(offer.getImages());
        return OfferResponse.builder()
                .id(offer.getId())
                .city(offer.getCity())
                .days(offer.getDays())
                .offer_description(offer.getOfferDesc())
                .animal_description(offer.getAnimalDesc())
                .title(offer.getTitle())
                .price(offer.getPrice())
                .animal_type(offer.getAnimalType())
                .contact(offer.getContact())
                .images(imageUrls)
                .build();
    }

    public OfferResponse updateOffer(Long id, OfferRequest offerRequest) {
        if (id == null) {
            throw new RuntimeException("Id is required");
        }
      /*  Set<Image> images = imageService.uploadImages(offerRequest.getImages()).stream().map(image -> Image.builder()
                .url(image)
                .build()).collect(Collectors.toSet());*/

        var offer = offerRepository.findById(id).orElseThrow(() -> new RuntimeException("Offer not found"));
        if(offerRequest.getCity() != null) {
            offer.setCity(offerRequest.getCity());
        }
        if(offerRequest.getDays() != 0) {
            offer.setDays(offerRequest.getDays());
        }
        if(offerRequest.getOffer_description() != null) {
            offer.setOfferDesc(offerRequest.getOffer_description());
        }
        if(offerRequest.getAnimal_description() != null) {
            offer.setAnimalDesc(offerRequest.getAnimal_description());
        }
        if(offerRequest.getTitle() != null) {
            offer.setTitle(offerRequest.getTitle());
        }
        if(offerRequest.getPrice() != 0) {
            offer.setPrice(offerRequest.getPrice());
        }
        if(offerRequest.getAnimal_type() != null) {
            offer.setAnimalType(offerRequest.getAnimal_type());
        }
        if(offerRequest.getContact() != null) {
            offer.setContact(offerRequest.getContact());
        }
     /*   if(offerRequest.getImages() != null) {
            offer.setImages(images);
        }*/
        return OfferResponse.builder()
                .id(offer.getId())
                .city(offer.getCity())
                .days(offer.getDays())
                .offer_description(offer.getOfferDesc())
                .animal_description(offer.getAnimalDesc())
                .title(offer.getTitle())
                .price(offer.getPrice())
                .animal_type(offer.getAnimalType())
                .contact(offer.getContact())
                .images(offer.getImages().stream().map(image -> ImageResponse.builder().url(image.getUrl()).build()).collect(Collectors.toSet()))
                .build();
    }

    public void deleteOffer(Long id) {
        if (id == null) {
            throw new RuntimeException("Id is required");
        }
        var offer = offerRepository.findById(id).orElseThrow(() -> new RuntimeException("Offer not found"));
        offerRepository.delete(offer);
    }
}
