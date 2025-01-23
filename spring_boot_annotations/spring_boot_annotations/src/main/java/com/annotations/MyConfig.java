package com.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@ComponentScan(basePackages = {"mypack"})
public class MyConfig {

    @Bean("student1")   //Here I give the object name or id of the student because here is 2 bean for Student class
    public Student getStudent(){
        System.out.println("Creating First Student Object...");
        return new Student("Student1");
    }

    @Bean("student2")
    @Lazy
    public Student createStudent(){
        System.out.println("Creating Second Student Object...");
        return new Student("Student2");
    }

    @Bean
    public Sleeping getSleeping(){
        System.out.println("Creating Sleeping Object...");
        return new Sleeping();
    }

}
