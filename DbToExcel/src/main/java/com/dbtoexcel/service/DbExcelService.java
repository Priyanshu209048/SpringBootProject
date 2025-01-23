package com.dbtoexcel.service;

import com.dbtoexcel.helper.DbExcelHelper;
import com.dbtoexcel.model.Person;
import com.dbtoexcel.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class DbExcelService {

    @Autowired
    private PersonRepo personRepo;

    public ByteArrayInputStream getData() throws IOException {
        List<Person> all = personRepo.findAll();
        return DbExcelHelper.dataToExcel(all);
    }

}
