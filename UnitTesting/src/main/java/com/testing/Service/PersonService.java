package com.testing.Service;

import com.testing.Entity.Person;
import com.testing.Repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepo repo;

    public List<Person> getAllPerson() {
        return this.repo.findAll();
    }

    public PersonService(PersonRepo repo) {
        this.repo = repo;
    }
}
