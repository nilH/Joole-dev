package com.itlize.Joole.repository;

import com.itlize.Joole.entity.Product;
import com.itlize.Joole.entity.ProductType;
import com.itlize.Joole.entity.TechnicalSpecs;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> findByProductType(List<ProductType> productTypeList);
    List<Product> findByTechnicalSpecs(List<TechnicalSpecs> technicalSpecsList);
    List<Product> findByProductTypeAndTechnicalSpecs(List<ProductType> productTypeList, List<TechnicalSpecs> technicalSpecsList);

}
