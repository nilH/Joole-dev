package com.itlize.Joole.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="manufacturer")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="manufacturer_id")
    private int id;

    @Column(name="pwd")
    private String password;

    @Column(name="manufacturer_name")
    private String name;

    @Column(name="time_updated")
    private LocalDateTime timeUpdated;


    @Column(name="time_created")
    private LocalDateTime timeCreated;


    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="manufacturer",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Product> product;



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getTimeUpdated() {
        return timeUpdated;
    }

    public void setTimeUpdated(LocalDateTime timeUpdated) {
        this.timeUpdated = timeUpdated;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }



}
