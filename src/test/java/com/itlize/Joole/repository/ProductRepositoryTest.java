package com.itlize.Joole.repository;

import com.itlize.Joole.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryTest {
    @Autowired
    ProductRepository productRepository;
    @Test
    public void addProduct(){
        Product product=new Product();
        product.setProductName("productName");

        Product product1=productRepository.save(product);
        assert(product1.getProductId()!=null);
    }

    @Test
    public void searchByType(){
        String type="fans";
        Product product=new Product();
        product.setProductName("HVAC88811");
        product.setType(type);
        productRepository.save(product);
        List<Product> productList =productRepository.findByTypeIgnoreCaseContaining("fan");
        assert(productList.size()>0);
    }

    @Test
    public void filterBySpecs(){
        Product product=new Product();
        product.setProductName("HEV33811");
        product.setType("fan");
        product.setUserType("usertype");
        product.setApplication("application");
        product.setMountingLocation("mountinglocation");
        product.setAccessories("accessories");
        product.setModelYear(2022);
        product.setAirflow(2);
        product.setMaxPower(2);
        product.setSoundAtMaxSpeed(2);
        product.setFanSweepDiameter(2);
        product.setHeight(2);
        productRepository.save(product);
        List<Product> productList=productRepository.findByUserTypeAndApplicationAndMountingLocationAndAccessoriesAndModelYearAndAirflowAndMaxPowerAndSoundAtMaxSpeedAndFanSweepDiameterAndHeight("usertype","application","mountinglocation","accessories",2022,2,2,2,2,2);
        assert(productList.size()>0);
    }
}
