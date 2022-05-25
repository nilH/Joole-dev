package com.itlize.Joole.service;

import com.itlize.Joole.entity.Product;
import com.itlize.Joole.entity.Project;

import java.util.List;

public interface ProjectService {
    int addProductToProject(int productId, int projectId);
    //crud

    int deleteProductFromProject(int productId, int projectId);
    List<Product> getProductFromProject(int projectId);

    void addProject(Project project);

    void deleteProject(Project project);

    void updateProject(Project project, Integer projectId);

    List<Project> findAllProject();

    Project findById(Integer projectId);

    List<Project> findByName(String projectName);
}
