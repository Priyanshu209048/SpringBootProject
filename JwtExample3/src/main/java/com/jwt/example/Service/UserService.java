package com.jwt.example.Service;

import com.jwt.example.Entity.User;
import com.jwt.example.Reopsitories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    /*private List<User> store = new ArrayList<>();*/

    /*public UserService() {
        store.add(new User(UUID.randomUUID().toString(), "Priyanshu Baral", "priyanshu@gmail.com"), );
        store.add(new User(UUID.randomUUID().toString(), "Ashish Mishra", "ashish@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(), "Abhishek Mishra", "abhishek@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(), "Nitin Kumar", "nitin@gmail.com"));
    }*/

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUser(String username){
        Optional<User> user = userRepo.findByEmail(username);
        return user.orElse(null);
    }

    public User createUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        return userRepo.save(user);
    }

    /*public List<User> getUsers() {
        return this.store;
    }*/

    /*public String getUser(Principal principal) {
        return principal.getName();
    }*/

}
