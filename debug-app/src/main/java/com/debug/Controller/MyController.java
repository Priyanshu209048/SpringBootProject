package com.debug.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/about")
    public String getAbout(){
        String str = "This program is to test how to do debugging in web";
        str = str.toLowerCase();
        str = str.toUpperCase();
        return str;
    }

}
