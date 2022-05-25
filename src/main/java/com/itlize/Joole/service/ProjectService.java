package com.itlize.Joole.service;

import com.itlize.Joole.entity.Product;
import com.itlize.Joole.entity.Project;

import java.util.List;

public interface ProjectService {
    int addProductToProject(int productId, int projectId);
    //crud

    int deleteProductFromProject(int productId, int projectId);
    List<Product> getProductFromProject(int projectId);

    int addProject(Project project);

    int deleteProject(Project project);

    int updateProject(Project project, Integer projectId);

    List<Project> findAllProject();

    Project findById(Integer projectId);

    List<Project> findByName(String projectName);
}
