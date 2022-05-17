package com.itlize.Joole.controller;

import com.itlize.Joole.entity.Product;
import com.itlize.Joole.entity.ProductType;
import com.itlize.Joole.entity.TechnicalSpecs;
import com.itlize.Joole.service.ProductSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//product line search
// product filter
//both return product list
@RestController
public class ProductSearchController {
    @Autowired
    ProductSearch productSearchService;
    @GetMapping(value = "/line_search")
    public List<Product> lineSearch(@RequestParam(name = "category") int categoryId, @RequestParam(name = "product_name") String name){
        return productSearchService.searchByName(name, categoryId);
    }

    @GetMapping(value = "/product_filter")
    public List<Product> productFilter(@RequestParam(name = "product_types")List<ProductType> productTypeList, @RequestParam(name = "technical_specs")List<TechnicalSpecs> technicalSpecsList){
        return productSearchService.filterByTypeAndSpecs(productTypeList,technicalSpecsList);
    }
}
