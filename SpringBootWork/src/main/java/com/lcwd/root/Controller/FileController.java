package com.lcwd.root.Controller;

import com.lcwd.root.Service.FilesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

@RestController
public class FileController {

    @Autowired
    private FilesService filesService;

    private Logger logger = LoggerFactory.getLogger(FileController.class);

    @PostMapping("/upload-files")
    public ResponseEntity<?> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files){
        this.logger.info("{} number of files uploaded", files.length);

        Arrays.stream(files).forEach(multipartFile -> {
            logger.info("File Name {}", multipartFile.getOriginalFilename());
            logger.info("File Size {}", multipartFile.getSize());
            logger.info("File Type {}", multipartFile.getContentType());
            System.out.println("---------------------");
            this.filesService.addFiles(multipartFile);
        });

        return ResponseEntity.ok("File Uploaded Successfully");
    }

}
