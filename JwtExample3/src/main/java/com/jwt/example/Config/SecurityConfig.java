package com.jwt.example.Config;

import com.jwt.example.Security.JwtAuthenticationEntryPoint;
import com.jwt.example.Security.JwtAuthenticationFilter;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private UserDetailsService userDetailsService;  //We get this from the custom user detail service

    @Autowired
    private PasswordEncoder passwordEncoder;    //We get this from the App config

    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {

        //Configuration
        http.csrf(AbstractHttpConfigurer::disable)
                /*.cors(AbstractHttpConfigurer::disable)*/
                .authorizeHttpRequests(auth -> auth.requestMatchers("/home/**").authenticated()
                                .requestMatchers("/auth/**").permitAll()
                                /*.requestMatchers("/auth/create-user").permitAll()
                                .requestMatchers("/auth/refresh").permitAll()*/
                                .anyRequest().authenticated())
                .exceptionHandling(exp -> exp.authenticationEntryPoint(jwtAuthenticationEntryPoint))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();

    }

    @Bean
    public DaoAuthenticationProvider getDaoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);

        return daoAuthenticationProvider;
    }

}
