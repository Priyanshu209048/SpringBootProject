package com.springdatajpamapping.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jpa_product")
public class Product {

    @Id
    private String pId;
    private String productName;

    @ManyToMany(mappedBy = "products", fetch = FetchType.EAGER)
    private List<Category> categories = new ArrayList<Category>();

    public Product() {
    }

    public Product(String pId, List<Category> categories, String productName) {
        this.pId = pId;
        this.categories = categories;
        this.productName = productName;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
