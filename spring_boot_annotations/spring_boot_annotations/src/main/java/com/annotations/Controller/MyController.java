package com.annotations.Controller;

import com.annotations.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
//@Controller
public class MyController {

    @Autowired
    @Qualifier("student2")
    private Student student;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(){
        System.out.println("This is home method");
        return "This is my name";
    }

    @RequestMapping(value = "/home1", method = RequestMethod.GET)
    public Student home1(@RequestBody Student st){
        st.studying();
        System.out.println("This is home1 method");
        this.student.setName("Pri");
        return this.student;
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public String user(@PathVariable("userId") Integer userId){
        return String.valueOf(userId);
    }

}
