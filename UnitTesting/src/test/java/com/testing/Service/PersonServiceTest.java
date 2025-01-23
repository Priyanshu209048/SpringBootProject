package com.testing.Service;

import com.testing.Repo.PersonRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    //@Autowired
    private PersonService personService;

    //We want to create a fake data that's why we didn't add Autowired annotation otherwise we get the actual data
    @Mock   //This is used to create the fake data
    private PersonRepo personRepo;

    //AutoCloseable autoCloseable;    //we can also use this instead of using @ExtendWith(MockitoExtension.class) in class

    @BeforeEach
    void setUp() {
        this.personService = new PersonService(this.personRepo);
        /*autoCloseable = MockitoAnnotations.openMocks(this);*/
    }

    /*@AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }*/

    @Test
    void getAllPerson() {
        personService.getAllPerson();
        verify(personRepo).findAll();
    }
}