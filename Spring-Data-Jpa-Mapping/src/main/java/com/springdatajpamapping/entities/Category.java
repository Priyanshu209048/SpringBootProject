package com.springdatajpamapping.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jpa_category")
public class Category {

    @Id
    private String id;
    private String title;

    //By default, it was lazy that's why we use fetch type Eager in this it immediately returns the data when it saw that
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Product> products = new ArrayList<Product>();

    public Category() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category(String id, List<Product> products, String title) {
        this.id = id;
        this.products = products;
        this.title = title;
    }
}
