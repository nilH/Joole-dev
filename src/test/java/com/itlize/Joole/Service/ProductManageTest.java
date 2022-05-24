package com.itlize.Joole.Service;

import com.itlize.Joole.entity.Product;
import com.itlize.Joole.repository.ProductRepository;
import com.itlize.Joole.service.ProductService;
import com.itlize.Joole.service.serviceImpl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
public class ProductManageTest {

    @Autowired
    @InjectMocks
    ProductServiceImpl productService;

    @Mock
    ProductRepository productRepository;

    @Test
    public void addProductTest(){
        Product product1=new Product();
        product1.setProductId(1);
        Mockito.when(productRepository.save(Mockito.any())).thenReturn(product1);
        Product product=new Product();
        product.setProductName("productName");
        product.setType("type");
        int id=productService.addProduct(product);
        assert(id==1);
    }
}
