package com.springdatajpamapping.repo;

import com.springdatajpamapping.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {
}
