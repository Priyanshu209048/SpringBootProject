package com.filedemo.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

public interface FileService {

    String uploadImage(String path, MultipartFile file) throws IOException;

    InputStream getResources(String path, String fileName) throws IOException;

}
