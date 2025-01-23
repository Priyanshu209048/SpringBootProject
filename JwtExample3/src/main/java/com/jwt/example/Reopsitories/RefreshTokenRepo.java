package com.jwt.example.Reopsitories;

import com.jwt.example.Entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepo extends JpaRepository<RefreshToken, String> {

    public Optional<RefreshToken> findByRefresh(String refresh);

}
