package com.itlize.Joole.service.serviceImpl;

import com.itlize.Joole.entity.Product;
import com.itlize.Joole.repository.ProductRepository;
import com.itlize.Joole.service.ManufacturerManage;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class ManufacturerService implements ManufacturerManage {
    @Autowired
    ProductRepository productRepository;
    @Override
    public int addProduct(Product product) {
        product.setTimeCreated(LocalDateTime.now());
        productRepository.save(product);
        return 0;
    }
}
