package com.loginrest.Controller;

import com.loginrest.Entity.Emp;
import com.loginrest.Entity.Message;
import com.loginrest.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MyController {

    @Autowired
    private EmpService empService;
    @Autowired
    private BCryptPasswordEncoder getBCryptPasswordEncoder;

    @PostMapping("/emp")
    public Message addEmp(@RequestBody Emp emp) {
        try {
            emp.setPassword(getBCryptPasswordEncoder.encode(emp.getPassword()));
            Emp result = this.empService.addEmp(emp);
            System.out.println(result);
            return new Message("Success", "Employee successfully added");
        } catch (Exception e){
            e.printStackTrace();
            return new Message("Error", "Something went wrong");
        }
    }

    @GetMapping("emp/index")
    public String getLogin(){
        return "Success";
    }

}
