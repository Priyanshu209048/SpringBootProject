package com.uploadcloud.uploadimageapi.service;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryImageServiceImple implements CloudinaryImageService{

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public Map uploadImage(MultipartFile multipartFile) {

        try {
            Map data = this.cloudinary.uploader().upload(multipartFile.getBytes(), Map.of());
            return data;
        } catch (IOException e) {
            throw new RuntimeException("Upload image failed");
        }
    }
}
