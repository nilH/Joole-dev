package com.itlize.Joole.Manufacturer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itlize.Joole.entity.Product;
import com.itlize.Joole.entity.ProductType;
import com.itlize.Joole.entity.TechnicalSpecs;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.SharedHttpSessionConfigurer.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class productManageTest {
    @Autowired
    MockMvc mockMvc;
    @Test
    public void addProduct() throws Exception{
        Product product=new Product();
        product.setProductName("productname");
        product.setBrand("brand");
        product.setType("searchType");
        product.setCertificate("certificate");
        product.setModelYear(LocalDateTime.of(2022,0,0,0,0));
        List<ProductType> productTypeList=new ArrayList<>();
        ProductType productType=new ProductType();
        productType.setAttributeName("attribute name");
        productType.setValue("attribute value");
        productTypeList.add(productType);
        List<TechnicalSpecs> technicalSpecsList=new ArrayList<>();
        TechnicalSpecs technicalSpecs=new TechnicalSpecs();
        technicalSpecs.setAttributeName("attribute name");
        technicalSpecs.setValue(5.0);
        technicalSpecs.setUnit("unit");
        technicalSpecsList.add(technicalSpecs);
        product.setProductTypeList(productTypeList);
        product.setTechnicalSpecsList(technicalSpecsList);
        mockMvc.perform(post("/manufacturer/add_product").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(product)));
    }
}
