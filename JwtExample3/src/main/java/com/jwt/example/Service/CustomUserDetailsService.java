package com.jwt.example.Service;

import com.jwt.example.Entity.User;
import com.jwt.example.Reopsitories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Load user from Database
        User user = userRepo.findByEmail(username).orElseThrow(() -> new RuntimeException("User not found")); //This is for optional<>
        /*User user = userRepo.findByEmail(username);*/

        return user;
    }
}
