package com.api.service;

import com.api.entity.Person;
import com.api.helper.ExcelHelper;
import com.api.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    private PersonRepo personRepo;

    //This method is used to save the person
    public void save(MultipartFile file) {
        try {
            List<Person> people = ExcelHelper.convertExcelToListOfPerson(file.getInputStream());
            this.personRepo.saveAll(people);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //This method is used to get the list of persons
    public List<Person> getPersonsList() {
        return this.personRepo.findAll();
    }

}
