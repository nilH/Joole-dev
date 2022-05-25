package com.itlize.Joole.service;

import com.itlize.Joole.entity.Product;
import com.itlize.Joole.entity.Project;

import java.util.List;

public interface ProjectService {
    int addProductToProject(int productId, int projectId);
    //crud

    int deleteProductFromProject(int productId, int projectId);
    List<Product> getProductFromProject(int projectId);

    //crud
    int createProject(Project project);
    List<Project> findAllProject();

    List<Project> findByName(String projectName);
    int updateProject(Project projuct, int projectId);
    int deleteProject(Project project);
}
