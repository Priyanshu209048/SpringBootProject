package com.api.controller;

import com.api.entity.Person;
import com.api.helper.ExcelHelper;
import com.api.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class PersonController {

    @Autowired
    private ExcelService excelService;

    @PostMapping("/person/upload")
    public ResponseEntity<?> uploadExcel(@RequestParam("file") MultipartFile file) throws InterruptedException {

        Thread.sleep(5000);
        if(ExcelHelper.checkExcelFormat(file)){
            //true
            this.excelService.save(file);
            return ResponseEntity.ok(Map.of("message", "File is uploaded successfully and data is saved to database"));
        }
        //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload the Excel sheet file");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", "Please upload the Excel sheet file"));
    }

    @GetMapping("/person")
    public List<Person> getAllPersons(){
        return this.excelService.getPersonsList();
    }

}
