package com.springdatajpamapping;

import com.springdatajpamapping.entities.*;
import com.springdatajpamapping.repo.CategoryRepo;
import com.springdatajpamapping.repo.ProductRepo;
import com.springdatajpamapping.repo.StudentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringDataJpaMappingApplication implements CommandLineRunner {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ProductRepo productRepo;

    private Logger logger  = LoggerFactory.getLogger(SpringDataJpaMappingApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaMappingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //oneToOneMapping();

        //oneToManyMapping();

        manyToManyMapping();

    }

    public void oneToOneMapping(){
        Student student = new Student();
        Laptop laptop = new Laptop();

        /*student.setStudentId(3);
        student.setStudentName("Sohan");
        student.setAbout("Backend Developer");

        laptop.setLaptopId(13);
        laptop.setBrand("ACER");
        laptop.setModelNumber("99999");

        laptop.setStudent(student);
        student.setLaptop(laptop);

        Student save = studentRepo.save(student);

        logger.info("Student Name : {}", save.getStudentName());*/

        Student student1 = studentRepo.findById(1).get();
        logger.info(student1.getStudentName());
        System.out.println(student1);

        Laptop laptop1 = student1.getLaptop();
        logger.info("{}, {}", laptop1.getBrand(), laptop1.getModelNumber());
        System.out.println(laptop1);
    }

    public void oneToManyMapping(){
        Student student = new Student();

        Student student1 = studentRepo.findById(1).get();

        Address address1 = new Address();
        address1.setAddressId(1);
        address1.setStreet("Street 1");
        address1.setCity("City 1");
        address1.setState("State 1");
        address1.setStudent(student1);

        Address address2 = new Address();
        address2.setAddressId(2);
        address2.setStreet("Street 2");
        address2.setCity("City 2");
        address2.setState("State 2");
        address2.setStudent(student1);

        List<Address> addresses = new ArrayList<>();
        addresses.add(address1);
        addresses.add(address2);

        student1.setAddressList(addresses);

        student1.setAddressList(addresses);

        Student savedStudent = studentRepo.save(student1);
        logger.info("{},{}", savedStudent.getStudentName(), savedStudent.getAddressList());

    }

    public void manyToManyMapping(){

//        Product product1 = new Product();
//        product1.setpId("1");
//        product1.setProductName("Realme 9 pro");
//
//        Product product2 = new Product();
//        product2.setpId("2");
//        product2.setProductName("Samsung S22 ultra");
//
//        Product product3 = new Product();
//        product3.setpId("3");
//        product3.setProductName("Samsung TV123");
//
//        Category category1 = new Category();
//        category1.setId("101");
//        category1.setTitle("Electronics");
//
//        Category category2 = new Category();
//        category2.setId("102");
//        category2.setTitle("Mobile Phones");
//
//        List<Product> category1Products = category1.getProducts();
//        category1Products.add(product1);
//        category1Products.add(product2);
//        category1Products.add(product3);
//
//        List<Product> category2Products = category2.getProducts();
//        category2Products.add(product1);
//        category2Products.add(product2);
//
//        categoryRepo.save(category1);
//        categoryRepo.save(category2);

        Category category1 = categoryRepo.findById("101").get();
        System.out.println("Size of the Products in Category1 " + category1.getProducts().size());

        Category category2 = categoryRepo.findById("102").get();
        System.out.println("Size of the Products in Category2 " + category2.getProducts().size());

        Product product1 = productRepo.findById("1").get();
        System.out.println("Size of the Categories in Product1 " + product1.getCategories().size());

        Product product2 = productRepo.findById("2").get();
        System.out.println("Size of the Categories in Product2 " + product2.getCategories().size());

        Product product3 = productRepo.findById("3").get();
        System.out.println("Size of the Categories in Product3 " + product3.getCategories().size());

    }

}
