package com.springdatajpamapping.repo;

import com.springdatajpamapping.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, String> {
}
