package com.spring.security.test.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity   //It was by default true
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {

        /*UserDetails normalUser = User.withUsername("Priyanshu")
                .password(getBCryptPasswordEncoder().encode("123456"))
                .roles("NORMAL").build();

        UserDetails adminUser = User.withUsername("Priyanshu1")
                .password(getBCryptPasswordEncoder().encode("123456"))
                .roles("ADMIN").build();

        UserDetails adminUser1 = User.withUsername("Priyanshu2")
                .password(getBCryptPasswordEncoder().encode("123456"))
                .roles("ADMIN").build();

        *//*UserDetails publicUser = User.withUsername("Priyanshu3")
                .password(getBCryptPasswordEncoder().encode("123456"))
                .roles("PUBLIC").build();*//*

        return new InMemoryUserDetailsManager(normalUser, adminUser, adminUser1);*/

        //When we use Database
        return new customUserDetailService();

    }

    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /*http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/home/public").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin ->
                formLogin
                        .loginPage("/login")
                        .permitAll()
                );*/
        http.authorizeHttpRequests()
                /*.requestMatchers("/home/admin")
                .hasRole("ADMIN")
                .requestMatchers("/home/normal")
                .hasRole("NORMAL")*/
                .requestMatchers("/home/public")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();

        return http.build();
    }

}
