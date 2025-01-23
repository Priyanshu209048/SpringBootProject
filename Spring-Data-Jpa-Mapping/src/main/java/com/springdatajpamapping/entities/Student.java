package com.springdatajpamapping.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jpa_student")
public class Student {

    @Id
    private int studentId;
    private String studentName;
    private String about;

    //It will be the uni-directional mapping if we didn't map the student entity in laptop
    //Or if we map the student entity in laptop then it will be the bidirectional mapping
    //But this create foreign key in both tables
    /*@OneToOne
    private Laptop laptop;*/

    //Here cascade is used to save the laptop record automatically when we add the Student data into the repository
    //Because of this we don't need to create the LaptopRepository
    //CascadeType.ALL perform all the operations like Refresh, Detach, Merge, Persist, Remove
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Laptop laptop;

    //In unidirectional mapping it creates a separate table to manage the relation which contain 2 column of 2 foreign keys of both the table.
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Address> addressList = new ArrayList<>();

    public Student(int studentId, List<Address> addressList, Laptop laptop, String about, String studentName) {
        this.studentId = studentId;
        this.addressList = addressList;
        this.laptop = laptop;
        this.about = about;
        this.studentName = studentName;
    }

    public Student() {

    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", about='" + about + '\'' +
                '}';
    }
}
