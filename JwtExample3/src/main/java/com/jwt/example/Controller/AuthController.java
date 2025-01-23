package com.jwt.example.Controller;

import com.jwt.example.Entity.RefreshToken;
import com.jwt.example.Entity.User;
import com.jwt.example.Model.JwtRequest;
import com.jwt.example.Model.JwtResponse;
import com.jwt.example.Model.RefreshTokenRequest;
import com.jwt.example.Security.JwtHelper;
import com.jwt.example.Service.RefreshTokenService;
import com.jwt.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private UserService userService;

    @Autowired
    private RefreshTokenService refreshTokenService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest jwtRequest) {

        this.doAuthenticate(jwtRequest.getUsername(), jwtRequest.getPassword());

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = jwtHelper.generateToken(userDetails);

        RefreshToken refreshToken = refreshTokenService.createRefreshToken(jwtRequest.getUsername());
        System.out.println(refreshToken);

        JwtResponse jwtResponse = JwtResponse.builder()
                .jwtToken(token)
                .refreshToken(refreshToken.getRefresh())
                .username(userDetails.getUsername())
                .build();

        return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
    }

    private void doAuthenticate(String name, String password){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(name, password);
        try{
            authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        }catch(BadCredentialsException e){
            throw new BadCredentialsException("Invalid username or password!!");
        }
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtResponse> refreshJwtToken(@RequestBody RefreshTokenRequest request){
        RefreshToken refreshToken = refreshTokenService.verifyRefreshToken(request.getRefreshToken());
        User user = refreshToken.getUser();
        String token = this.jwtHelper.generateToken(user);
        JwtResponse jwtResponse = JwtResponse.builder().jwtToken(token).
                refreshToken(refreshToken.getRefresh()).
                username(user.getEmail()).build();

        return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler(){
        return "Credentials Invalid !!";
    }

    @PostMapping("/create-user")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

}
