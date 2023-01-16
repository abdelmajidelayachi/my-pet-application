package com.example.mypet.services;

import com.example.mypet.provider.CloudinaryProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final CloudinaryProvider cloudinaryProvider;
    public List<String> uploadImages(MultipartFile[] images){
        List<String> imageUrls = new ArrayList<>();
        for (MultipartFile image : images) {
            String url = cloudinaryProvider.uploadImage(image);
            imageUrls.add(url);
            System.out.println(url);
        }
        return imageUrls;
    }

}
