package com.itlize.Joole.service.serviceImpl;

import com.itlize.Joole.entity.Product;
import com.itlize.Joole.entity.Project;
import com.itlize.Joole.entity.ProjectProduct;
import com.itlize.Joole.repository.ProductRepository;
import com.itlize.Joole.repository.ProjectProductRepository;
import com.itlize.Joole.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProjectManage {

    @Autowired
    ProjectRepository projectRep;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProjectProductRepository ppRepository;

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
}
