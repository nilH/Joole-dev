package com.itlize.Joole.service.serviceImpl;

import com.itlize.Joole.entity.Product;
import com.itlize.Joole.repository.ProductRepository;
import com.itlize.Joole.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public int addProduct(Product product) {
        product.setTimeCreated(LocalDateTime.now());
        return productRepository.save(product).getProductId();
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }
}
