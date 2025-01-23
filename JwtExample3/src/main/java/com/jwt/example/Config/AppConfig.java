package com.jwt.example.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig {

    /*@Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetail = User.builder().username("Priyanshu").password(passwordEncoder().encode("Priyanshu")).roles("ADMIN").build();
        UserDetails userDetail1 = User.builder().username("Rohan").password(passwordEncoder().encode("Rohan")).roles("NORMAL").build();

        return new InMemoryUserDetailsManager(userDetail, userDetail1);
    }*/

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

}
