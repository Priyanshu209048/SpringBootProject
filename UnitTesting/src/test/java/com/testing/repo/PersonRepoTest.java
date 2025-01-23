package com.testing.repo;

import com.testing.Entity.Person;
import com.testing.Repo.PersonRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepoTest {

    @Autowired
    private PersonRepo personRepo;

    @Test
    void isPersonExistsById() {
        Person person = new Person(1001, "Priyanshu", "Delhi");
        personRepo.save(person);

        Boolean actualResult = personRepo.isPersonExistsById(1001);
        assertThat(actualResult).isTrue();
        //assertThat(actualResult).isFalse(); //It passed the test if the person is not exists
    }

    @AfterEach  //This method runs after every test
    void tearDown() {
        System.out.println("Tearing down");
        personRepo.deleteAll();
    }

    @BeforeEach //This method runs before every test
    void setUp() {
        System.out.println("Setting up");
    }
}