package com.jwt.example.Model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class JwtRequest {

    private String username;
    private String password;

}
