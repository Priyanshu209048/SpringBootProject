package com.jwt.example.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tokenId;

    private String refresh;
    private Instant expiresAt;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

}
