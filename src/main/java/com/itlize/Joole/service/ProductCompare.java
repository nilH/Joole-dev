package com.itlize.Joole.service;

import com.itlize.Joole.entity.Product;

import java.util.List;

public interface ProductCompare {
    List<Product> getProductList(List<Integer> productIds);
}
