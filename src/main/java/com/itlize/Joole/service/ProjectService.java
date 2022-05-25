package com.itlize.Joole.service;

import com.itlize.Joole.entity.Product;

import java.util.List;

public interface ProjectService {
    int addProductToProject(int productId, int projectId);
    //crud

    int deleteProductFromProject(int productId, int projectId);
    List<Product> getProductFromProject(int projectId);
}
