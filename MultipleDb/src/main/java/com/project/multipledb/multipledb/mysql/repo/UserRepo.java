package com.project.multipledb.multipledb.mysql.repo;

import com.project.multipledb.multipledb.mysql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
