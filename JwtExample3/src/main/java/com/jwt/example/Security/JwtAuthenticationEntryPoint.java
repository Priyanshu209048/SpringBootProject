package com.jwt.example.Security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

//Method of this class is called whenever as exception is thrown due to unauthenticated user is trying to access the resource that required authentication.
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        //response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter out = response.getWriter();
        out.println("Access Denied !! " + authException.getMessage());
    }
}
