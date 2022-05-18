package com.itlize.Joole.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="product",indexes = @Index(name = "lineSearch",columnList = "type"))
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private int productId;
    @NotNull
    @Column(name="product_name")
    private String productName;

    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="product",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private Set<ProjectProduct> projectProductSet;

    @NotNull
    @Column(name="time_created")
    private LocalDateTime timeCreated;
    @NotNull
    @Column(name = "model_year")
    private LocalDateTime modelYear;
    @NotNull
    private String brand;

    private String certificate;


    private String category;
    @NotNull
    //type is used for search. like "HVAC fans"
    private String type;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "product_info_id")
    private ProductInfo productInfo;


    private String manufacturer;

    @Column(name = "user_type")
    private String userType;
    private String application;
    @Column(name = "mounting_location")
    private String mountingLocation;

    private double airflow;
    @Column(name = "max_power")
    private double maxPower;

    @Column(name = "sound_at_max_speed")
    private double soundAtMaxSpeed;

    @Column(name = "fan_sweep_diameter")
    private double fanSweepDiameter;
    private double height;
    private String accessories;


    public String getAccessories() {
        return accessories;
    }

    public void setAccessories(String accessories) {
        this.accessories = accessories;
    }

    public String getCategory() {
        return category;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public String getManufacturer() {
        return manufacturer;
    }


    public double getAirflow() {
        return airflow;
    }

    public void setAirflow(double airflow) {
        this.airflow = airflow;
    }

    public double getFanSweepDiameter() {
        return fanSweepDiameter;
    }

    public void setFanSweepDiameter(double fanSweepDiameter) {
        this.fanSweepDiameter = fanSweepDiameter;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(double maxPower) {
        this.maxPower = maxPower;
    }

    public double getSoundAtMaxSpeed() {
        return soundAtMaxSpeed;
    }

    public void setSoundAtMaxSpeed(double soundAtMaxSpeed) {
        this.soundAtMaxSpeed = soundAtMaxSpeed;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getMountingLocation() {
        return mountingLocation;
    }

    public void setMountingLocation(String mountingLocation) {
        this.mountingLocation = mountingLocation;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

}
