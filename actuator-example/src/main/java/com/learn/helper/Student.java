package com.learn.helper;

import org.springframework.stereotype.Component;

@Component //It automatically detects our custom bean without adding the @Bean.
public class Student {

    public Student(){
        System.out.println("Creating the object of the Student");
    }

}
