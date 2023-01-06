package com.example.mypet.payload.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class AnimalRequest {

    private String description;
    private String type;

}
