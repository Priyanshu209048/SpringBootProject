package com.springdatajpamapping.repo;

import com.springdatajpamapping.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, String> {
}
