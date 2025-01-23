package com.springdatajpamapping.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "jpa_laptop")
public class Laptop {

    @Id
    private int laptopId;
    private String modelNumber;
    private String brand;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Laptop(int laptopId, Student student, String brand, String modelNumber) {
        this.laptopId = laptopId;
        this.student = student;
        this.brand = brand;
        this.modelNumber = modelNumber;
    }

    public Laptop() {
    }

    public int getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(int laptopId) {
        this.laptopId = laptopId;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "laptopId=" + laptopId +
                ", modelNumber='" + modelNumber + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
