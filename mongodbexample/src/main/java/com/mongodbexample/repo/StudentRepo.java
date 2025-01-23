package com.mongodbexample.repo;

import com.mongodbexample.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student, Integer> {
}
