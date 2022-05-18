package com.itlize.Joole.controller;

import com.itlize.Joole.entity.Product;
import com.itlize.Joole.service.ManufacturerManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManufacturerController {
    @Autowired
    ManufacturerManage manufacturerManage;
    @PostMapping(value = "/manufacturer/add_product")
    public void addProduct(@RequestBody Product product){
        manufacturerManage.addProduct(product);
    }
}
