package com.itlize.Joole.controller;

import com.itlize.Joole.entity.Product;
import com.itlize.Joole.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    ProductService manufacturerManage;
    @PostMapping(value = "/add_product")
    public void addProduct(@RequestBody Product product){
        manufacturerManage.addProduct(product);
    }



}
