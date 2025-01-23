package com.lcwd.root.Service;

import com.lcwd.root.Model.Filess;
import com.lcwd.root.Repository.FilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FilesService {

    @Autowired
    private FilesRepository filesRepository;

    public Filess addFiles(MultipartFile files) {

        Filess filess = new Filess();
        try {
            if (files.isEmpty()){
                System.out.println("There is no file to upload");
                return null;
            }else {
                filess.setFileName(files.getOriginalFilename());

                File saveFile = new ClassPathResource("static/img/").getFile();
                Path savePath = Paths.get(saveFile + File.separator + filess.getFileName());
                Files.copy(files.getInputStream(), savePath, StandardCopyOption.REPLACE_EXISTING);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return filesRepository.save(filess);
    }

}
