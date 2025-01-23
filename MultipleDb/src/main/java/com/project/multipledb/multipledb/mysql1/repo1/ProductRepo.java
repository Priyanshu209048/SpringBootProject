package com.project.multipledb.multipledb.mysql1.repo1;

import com.project.multipledb.multipledb.mysql1.entity1.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {

    Product findByName(String name);

}
