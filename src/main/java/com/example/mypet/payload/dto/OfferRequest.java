package com.example.mypet.payload.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class OfferRequest {
    private String city;
    private int days;
    private String animal_description;
    private String offer_description;
    private float price;
    private String animal_type;
    private String contact;
    private String title;
    private MultipartFile[] images;
    /*
    title 1
offers.service.ts:34 animal_type bird
offers.service.ts:34 offer_description Rerum beatae laudant
offers.service.ts:34 animal_description Dolore consequatur
offers.service.ts:34 price 171
offers.service.ts:34 days 3
offers.service.ts:34 contact +1 (149) 788-2594
offers.service.ts:34 city Voluptatibus dolorem
    */
}
