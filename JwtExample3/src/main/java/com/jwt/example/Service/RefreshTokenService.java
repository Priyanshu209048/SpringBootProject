package com.jwt.example.Service;

import com.jwt.example.Entity.RefreshToken;
import com.jwt.example.Entity.User;
import com.jwt.example.Reopsitories.RefreshTokenRepo;
import com.jwt.example.Reopsitories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class RefreshTokenService {

    public long tokenValidity = 2 * 60 * 1000;

    @Autowired
    private RefreshTokenRepo refreshTokenRepo;

    @Autowired
    private UserRepo userRepo;

    public RefreshToken createRefreshToken(String username) {

        User user = userRepo.findByEmail(username).get();
        RefreshToken refreshToken = user.getRefreshToken();

        if(refreshToken == null) {
            refreshToken = RefreshToken.builder().refresh(UUID.randomUUID().toString()).
                    expiresAt(Instant.now().plusMillis(tokenValidity))
                    .user(user).build();
        } else {
            refreshToken.setExpiresAt(Instant.now().plusMillis(tokenValidity));
        }

        user.setRefreshToken(refreshToken);

        refreshTokenRepo.save(refreshToken);

        return refreshToken;
    }

    public RefreshToken verifyRefreshToken(String refreshToken) {

        RefreshToken refreshToken1 = refreshTokenRepo.findByRefresh(refreshToken).orElseThrow(() -> new RuntimeException("Token doesn't Exists!!"));

        if (refreshToken1.getExpiresAt().compareTo(Instant.now()) < 0) {
            refreshTokenRepo.delete(refreshToken1);
            throw new RuntimeException("Token expired");
        }
        return refreshToken1;
    }

}
