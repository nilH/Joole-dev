package com.itlize.Joole.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private int productId;
    @NotNull
    @Column(name="product_name")
    private String productName;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "project_product",joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
    private Set<Project> projectSet=new HashSet<>();
    @NotNull
    @Column(name="time_created")
    private LocalDateTime timeCreated;
    @NotNull
    @Column(name = "model_year")
    private LocalDateTime modelYear;
    @NotNull
    @Column(name = "brand")
    private String brand;
    @NotNull
    @Column(name = "certificate")
    private String certificate;
    @NotNull
    @JoinColumn(name = "category")
    private String category;
    @NotNull
    //type is used for search. like "HVAC fans"
    private String type;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "product_info_id")
    private ProductInfo productInfo;
    @NotNull
    @JoinColumn(name = "manufacturer")
    private String manufacturer;
    @OneToMany(mappedBy = "product",cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    private List<ProductType> productTypeList;
    @OneToMany( mappedBy = "product",cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    private List<TechnicalSpecs> technicalSpecsList;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public List<ProductType> getProductTypeList() {
        return productTypeList;
    }

    public void setProductTypeList(List<ProductType> productTypeList) {
        this.productTypeList = productTypeList;
    }

    public List<TechnicalSpecs> getTechnicalSpecsList() {
        return technicalSpecsList;
    }

    public void setTechnicalSpecsList(List<TechnicalSpecs> technicalSpecsList) {
        this.technicalSpecsList = technicalSpecsList;
    }

    public LocalDateTime getModelYear() {
        return modelYear;
    }

    public void setModelYear(LocalDateTime modelYear) {
        this.modelYear = modelYear;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Project> getProjectSet() {
        return projectSet;
    }

    public void setProjectSet(Set<Project> projectSet) {
        this.projectSet = projectSet;
    }
}
