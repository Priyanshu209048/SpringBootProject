package com.lcwd.root.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lcwd.root.Model.User;
import com.lcwd.root.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

//In this we send 2 different data which is file and text with the help of one controller
@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private ObjectMapper mapper;    //ObjectMapper provide functionality of reading and writing JSON, either to and from basic POJOs (Plain Old Java Objects), or to and from a general-purpose JSON Tree Model ( JsonNode ), as well as related functionality for performing conversions.

    @PostMapping("/user/add")   //We are using requestParam instead of RequestBody because we want 2 different data in requestBody we can only able to send 1 data
    public ResponseEntity<?> addUserInformation(@RequestParam("file") MultipartFile file,
                                                @RequestParam("userData") String userData){

        this.logger.info("Add User Information");
        logger.info("File information: {}", file.getOriginalFilename());
//        logger.info("User: {}", userData);

        //Converting String into json
        User user = null;
        try {
            user = mapper.readValue(userData, User.class);
            this.userService.addUser(user, file);
            logger.info("{}", user);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid User Request");
        }

        logger.info("User: {}", userData);

        return ResponseEntity.ok(userData);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Integer id){
        User user = this.userService.getUserById(id);
        if (user == null) {
            System.out.println("User not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        //logger.info("User: {}", user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = this.userService.getAllUsers();
        if (users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(users);
        }
    }

}
