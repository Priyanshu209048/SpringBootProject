package com.filedemo.Controller;

import com.filedemo.Imple.FileServiceImple;
import com.filedemo.PlayLoad.FileResponse;
import com.filedemo.Service.FileService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileServiceImple fileServiceImple;

    @Value("${project.image}")
    private String path;

    @PostMapping("/upload")
    @ExceptionHandler(MultipartException.class)
    public ResponseEntity<FileResponse> fileUpload(@RequestParam("image") MultipartFile image) {
        String fileName = null;
        try {
            fileName = this.fileServiceImple.uploadImage(path, image);
        } catch (MultipartException | IOException | StringIndexOutOfBoundsException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
            return new ResponseEntity<>(new FileResponse(null, "Image is not uploaded due to error on server!!"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (fileName != null) {
            return new ResponseEntity<>(new FileResponse(fileName, "Image is successfully uploaded!!"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new FileResponse(fileName, "Please upload image only!!"), HttpStatus.BAD_REQUEST);
    }

    //Method to serve files
    @GetMapping(value = "/images/{imageName}",produces = MediaType.IMAGE_JPEG_VALUE)
    public void downloadImage(@PathVariable("imageName") String imageName, HttpServletResponse response) throws IOException {
        InputStream resource = this.fileServiceImple.getResources(path, imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resource, response.getOutputStream());
    }

}
