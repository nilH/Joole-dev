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

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ProductSearchTest {
    @Autowired
    @InjectMocks
    ProductServiceImpl productServiceImpl;

    @Mock
    ProductRepository productRepository;

    @Test
    public void productSearchByTypeTest(){
        List<Product> productList=new ArrayList<>();
        productList.add(new Product());
        Mockito.when(productRepository.findByTypeIgnoreCaseContaining("fan")).thenReturn(productList);
        List<Product> productList1;
        productList1=productServiceImpl.searchByType("fan");
        assert(productList1.size()>0);
    }
    @Test
    public void productFilterTest(){
        List<Product> productList=new ArrayList<>();
        productList.add(new Product());
        Mockito.when(productRepository.findByUserTypeAndApplicationAndMountingLocationAndAccessoriesAndModelYearAndAirflowAndMaxPowerAndSoundAtMaxSpeedAndFanSweepDiameterAndHeight("usertype","application","mountinglocation","accessories",2022,2,2,2,2,2)).thenReturn(productList);
        List<Product> productList1;
        productList1=productServiceImpl.filter("usertype","application","mountinglocation","accessories",2022,2,2,2,2,2);
        assert(productList1.size()>0);
    }
}
