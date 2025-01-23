package com.jwt.example.Controller;

import com.jwt.example.Entity.User;
import com.jwt.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers(){
        System.out.println("Getting Users");
        return this.userService.getAllUsers();
    }

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(Principal principal){
        System.out.println("Getting Current User");
        String username = principal.getName();
        System.out.println(username);
        /*return "{\"name\":\""+username+"\"}";*/
        return this.userService.getUser(username);
        /*return ResponseEntity.status(HttpStatus.OK).body(userDetails.getUsername());*/
    }

}
