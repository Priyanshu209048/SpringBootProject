package com.springdatajpamapping.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "jpa_address")
public class Address {

    @Id
    private int addressId;
    private String street;
    private String city;
    private String state;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Address() {
    }

    public Address(int addressId, Student student, String state, String city, String street) {
        this.addressId = addressId;
        this.student = student;
        this.state = state;
        this.city = city;
        this.street = street;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
