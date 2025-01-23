package com.jwtwithrole.controllers;

import com.jwtwithrole.models.UserEntity;
import com.jwtwithrole.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("users")
    public List<UserEntity> getAllUsers() {
        return userService.findAll();
    }

}
