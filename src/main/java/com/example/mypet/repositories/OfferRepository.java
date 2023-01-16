package com.example.mypet.repositories;

import com.example.mypet.entities.Offer;
import org.springframework.data.repository.CrudRepository;

public interface OfferRepository extends CrudRepository<Offer, Long> {
    //
}
