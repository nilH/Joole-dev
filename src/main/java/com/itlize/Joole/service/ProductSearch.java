package com.itlize.Joole.service;

import com.itlize.Joole.entity.Product;
import com.itlize.Joole.entity.ProductType;
import com.itlize.Joole.entity.TechnicalSpecs;

import java.util.List;

public interface ProductSearch {
    public List<Product> searchByName(String name);
    public List<Product> filterByTypeAndSpecs(List<ProductType> productTypeList, List<TechnicalSpecs> technicalSpecsList);
}
