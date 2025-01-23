package com.uploadcloud.uploadimageapi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;


public interface CloudinaryImageService {
    public Map uploadImage(MultipartFile multipartFile);
}
