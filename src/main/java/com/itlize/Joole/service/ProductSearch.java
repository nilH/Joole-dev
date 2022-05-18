package com.itlize.Joole.service;

import com.itlize.Joole.entity.Product;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductSearch {
    List<Product> searchByName(String name);
    List<Product> filter(String userType, String application, String mountingLocation, String accessories, LocalDateTime modelYear, double airflow, double maxPower, double soundAtMaxSpeed, double fanSweepDiameter, double height);
}
