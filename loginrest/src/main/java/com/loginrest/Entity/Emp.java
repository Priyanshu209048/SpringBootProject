package com.loginrest.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Emp {

    @Id
    private int empno;
    private String ename;
    private String email;
    private String password;

    public Emp(int empno, String ename, String email, String password) {
        this.empno = empno;
        this.ename = ename;
        this.email = email;
        this.password = password;
    }

    public Emp() {
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
