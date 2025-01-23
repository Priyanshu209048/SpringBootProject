package com.dbtoexcel.repo;

import com.dbtoexcel.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Integer> {
}
