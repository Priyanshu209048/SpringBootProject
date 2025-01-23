package com.filedemo.Imple;

import com.filedemo.Service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImple implements FileService {

    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException, MultipartException {

        //File name
        String name = file.getOriginalFilename();

        if (name.substring(name.lastIndexOf(".")).equals(".jpg") || name.substring(name.lastIndexOf(".")).equals(".png") || name.substring(name.lastIndexOf(".")).equals(".jpeg")) {
            //Random name generate file
            String randomId = String.valueOf(UUID.randomUUID());
            String fileName1 = randomId.concat(name.substring(name.lastIndexOf(".")));
            System.out.println(name.substring(name.lastIndexOf(".")));  //This will print the data from the right side of the "."
            System.out.println(name.lastIndexOf("."));  //This gives the index value of the "."

            //Full path
            String filePath = path + File.separator + fileName1;

            //Create folder if not created
            File dest = new File(path);
            if (!dest.exists()) {
                dest.mkdirs();
            }

            //file copy
            Files.copy(file.getInputStream(), Paths.get(filePath));

            return name;
        }
        return null;
    }

    @Override
    public InputStream getResources(String path, String fileName) throws IOException {

        String fullPath = path + File.separator + fileName;
        //InputStream is = new FileInputStream(fullPath);
        InputStream is = Files.newInputStream(Paths.get(fullPath));

        return is;
    }

}
