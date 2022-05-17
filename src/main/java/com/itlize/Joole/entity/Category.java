package com.itlize.Joole.entity;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="Category")
public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Category_id")
    private Integer Category_id;

    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="Category",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH,
                    CascadeType.REMOVE})
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Product> Products = new ArrayList<>();


    @Column(name="Category_name")
    private String Category_name ;


    public Category() {

    }

    public Category(String Category_name) {
        this.Category_name = Category_name;

    }

    public int getId() {
        return Category_id;
    }

    public void setId(int Category_id) {
        this.Category_id = Category_id;
    }

    public String getCategoryName() {
        return Category_name;
    }

    public void setCategoryName(String Category_name) {
        this.Category_name = Category_name;
    }


    public List<Product> getCourses() {
        return Products;
    }

    public void setCourses(List<Product> Products) {
        this.Products = Products;
    }

    // add convenience methods for bi-directional relationship

    public void add(Product tempProduct) {

        if(Products.contains(tempProduct)) {
            return;
        }

        Products.add(tempProduct);

        tempProduct.setCategory(this);
    }

}

