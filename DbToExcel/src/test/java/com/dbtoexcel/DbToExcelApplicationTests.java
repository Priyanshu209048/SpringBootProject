package com.dbtoexcel;

import com.dbtoexcel.repo.PersonRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootTest
class DbToExcelApplicationTests {

    @Autowired
    private PersonRepo personRepo;

    private Logger logger = LoggerFactory.getLogger(DbToExcelApplicationTests.class);

    @Test
    void contextLoads() {

        logger.info("Test Started");
        personRepo.findAll().forEach(person -> System.out.println(person.getEmail()));

    }

}
