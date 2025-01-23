package com.lcwd.root.Service;

import com.lcwd.root.Model.User;
import com.lcwd.root.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user, MultipartFile image) {
        try {
            if (image.isEmpty()){
                System.out.println("There is no image");
                user.setImageName("contact.png");
            } else {
                user.setImageName(image.getOriginalFilename());

                File saveFile = new ClassPathResource("static/img/").getFile();
                Path savePath = Paths.get(saveFile + File.separator + user.getImageName());
                Files.copy(image.getInputStream(), savePath, StandardCopyOption.REPLACE_EXISTING);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return userRepository.save(user);
    }

    public User getUserById(Integer id) {
        Optional<User> userOptional = this.userRepository.findById(id);
        User user = userOptional.get();
        return user;
    }

    public List<User> getAllUsers(){
        List<User> userList = this.userRepository.findAll();
        return userList;
    }

}
