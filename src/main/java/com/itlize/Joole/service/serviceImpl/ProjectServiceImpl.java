package com.itlize.Joole.service.serviceImpl;

import com.itlize.Joole.entity.Product;
import com.itlize.Joole.entity.Project;
import com.itlize.Joole.entity.ProjectProduct;
import com.itlize.Joole.repository.ProductRepository;
import com.itlize.Joole.repository.ProjectProductRepository;
import com.itlize.Joole.repository.ProjectRepository;
import com.itlize.Joole.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRep;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProjectProductRepository ppRepository;


    public int addProject(Project project){
        return 1;

    }

    public int deleteProject(Project project){
        return 1;
    }


    public int updateProject(Project project,int projectId) {

        return 0;
    }


    public Project findById(Integer projectId) {
        return null;
    }


    public List<Project> findAllProject() {
        return null;
    }


    public List<Project> findByName(String projectName) {
        return null;
    }



    @Override
    public int addProductToProject(int productId, int projectId)
    {
        Set<ProjectProduct> ppSet = new HashSet<ProjectProduct>();

        Product product=productRepository.findById(productId).orElse(null);
        Project project = projectRep.findById(projectId).orElse(null);

        ProjectProduct pp = new ProjectProduct();
        pp.setProduct(product);
        pp.setProject(project);

        ppRepository.save(pp);

        ppSet.add(pp);

        project.setProjectProduct(ppSet);
        product.setProjectProductSet(ppSet);

        return 1;

    }

    @Override
    public int deleteProductFromProject(int productId, int projectId) {
        return 0;
    }

    @Override
    public List<Product> getProductFromProject(int projectId) {
        return null;
    }
}