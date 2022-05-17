package com.itlize.Joole.service.serviceImpl;

import com.itlize.Joole.entity.Product;
import com.itlize.Joole.entity.ProductType;
import com.itlize.Joole.entity.TechnicalSpecs;
import com.itlize.Joole.repository.ProductRepository;
import com.itlize.Joole.service.ProductSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSearchService implements ProductSearch {
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> searchByName(String name, int categoryId) {
        return productRepository.findByCategoryCategoryIdAndTypeIgnoreCaseContaining(categoryId, name);
    }

    @Override
    public List<Product> filterByTypeAndSpecs(List<ProductType> productTypeList, List<TechnicalSpecs> technicalSpecsList) {
        return productRepository.findByProductTypeAndTechnicalSpecs(productTypeList,technicalSpecsList);
    }
}
