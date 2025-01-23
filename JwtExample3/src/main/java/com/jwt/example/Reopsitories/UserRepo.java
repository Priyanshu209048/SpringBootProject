package com.jwt.example.Reopsitories;

import com.jwt.example.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

    public Optional<User> findByEmail(String email);

}
