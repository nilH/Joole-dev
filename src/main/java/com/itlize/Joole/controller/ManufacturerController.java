package com.itlize.Joole.controller;

import com.itlize.Joole.entity.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManufacturerController {
    @PostMapping(value = "/manufacturer/add_product")
    public void addProduct(@RequestBody Product product){

    }
}
