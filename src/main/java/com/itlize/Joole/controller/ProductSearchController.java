package com.itlize.Joole.controller;

import com.itlize.Joole.entity.Product;
import com.itlize.Joole.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

//product line search
// product filter
//both return product list
@RestController
public class ProductSearchController {
    @Autowired
    ProductService productService;
    @GetMapping(value = "/line_search")
    public List<Product> lineSearch(@RequestParam(name = "product_name") String name){
        List<Product> result=productService.searchByType(name);
        return result;
    }

    @GetMapping(value = "/product_filter")
    public List<Product> productFilter(String userType, String application, String mountingLocation, String accessories, String modelYear, double airflow, double maxPower, double soundAtMaxSpeed, double fanSweepDiameter, double height){
        return productService.filter(userType,  application,  mountingLocation,  accessories,  Integer.parseInt(modelYear),  airflow,  maxPower,  soundAtMaxSpeed,  fanSweepDiameter,  height);
    }
}
