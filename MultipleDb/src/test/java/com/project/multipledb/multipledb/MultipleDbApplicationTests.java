package com.project.multipledb.multipledb;

import com.project.multipledb.multipledb.mysql.entity.User;
import com.project.multipledb.multipledb.mysql.repo.UserRepo;
import com.project.multipledb.multipledb.mysql1.entity1.Product;
import com.project.multipledb.multipledb.mysql1.repo1.ProductRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MultipleDbApplicationTests {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ProductRepo productRepo;

    private User user = new User();
    private Product product = new Product();

    @BeforeEach
    void setUp(){
        user = User.builder()
                .firstName("Priyanshu")
                .lastName("Baral")
                .email("priyanshu@gmail.com")
                .build();

        product = Product.builder()
                .name("Realme Phone")
                .price(19000)
                .live(true)
                .description("This is realme product")
                .build();
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void dbTest() {
        productRepo.save(product);
        userRepo.save(user);
        System.out.println("Saved");
    }

    @Test
    public void getData() {
        productRepo.findAll().forEach(product1 -> System.out.println("Product Name: " + product1.getName()));
        userRepo.findAll().forEach(user1 -> System.out.println("User Name: " + user1.getFirstName()));
    }

}
