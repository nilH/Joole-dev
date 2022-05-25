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

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRep;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProjectProductRepository ppRepository;

    @Override
    public int addProject(Project project){
        return 1;

    }
    @Override
    public int deleteProject(Project project){
        return 1;
    }

    @Override
    public int updateProject(Project project,Integer projectId) {

        return 0;
    }

    @Override
    public Project findById(Integer projectId) {
        return null;
    }

    @Override
    public List<Project> findAllProject() {
        return null;
    }

    @Override
    public List<Project> findByName(String projectName) {
        return null;
    }



    @Override
    public int addProductToProject(int productId, int projectId)
    {
        Set<ProjectProduct> ppSet = new HashSet<ProjectProduct>();

        Product product=productRepository.findById(productId).orElse(null);
        Project project = projectRep.findById(projectId).orElse(null);

        if(product == null || project ==null)
        {
            return 0;
        }

        ProjectProduct pp = new ProjectProduct();
        pp.setProduct(product);
        pp.setProject(project);

        try {
            ppRepository.save(pp);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            return 0;
        }

        ppSet.add(pp);

        project.setProjectProduct(ppSet);
        product.setProjectProductSet(ppSet);

        return 1;

    }

    @Override
    public Project findById(int projectId) {
        return projectRep.findById(projectId).orElse(null);
    }

    @Override
    public int deleteProductFromProject(int productId, int projectId) {

        Project project = projectRep.findById(projectId).orElse(null);
        Product product=productRepository.findById(productId).orElse(null);

        if(product == null || project ==null)
        {
            return 0;
        }

        List<ProjectProduct> ppList = ppRepository.findByProject(project);

        Iterator<ProjectProduct> it = ppList.iterator();  // Traverse the set

        while (it.hasNext()) {               // Delete every related ProjectProducts
            ProjectProduct pp = it.next();
            if(pp.getProduct().getProductId() == productId)
            {
                simpleDeleteProjectProduct(pp);     // This is a method in this class
            }
        }

        project.setProjectProduct(null);
        product.setProjectProductSet(null);

        return 1;
    }

    @Override
    public List<Product> getProductFromProject(int projectId) {

        List<Product> output = new ArrayList<Product>();

        Project project = projectRep.findById(projectId).orElse(null);

        if(project ==null)
        {
            return null;
        }

        List<ProjectProduct> ppList = ppRepository.findByProject(project);

        Iterator<ProjectProduct> it = ppList.iterator();  // Traverse the set

        while (it.hasNext()) {
            ProjectProduct pp = it.next();
            output.add(pp.getProduct());     // Add every product
        }

        return output;
    }

    public int createProject(Project project)
    {
        if(projectRep.findByProjectName(project.getProjectName()).size()>0)
        {
            return -1;
        }

        project.setTimeCreated(LocalDateTime.now());

        return projectRep.save(project).getId();
    }

    public List<Project> findAllProject()
    {
        return projectRep.findAll();
    }

    public List<Project> findByName(String projectName)
    {
        return projectRep.findByProjectName(projectName);
    }

    public int updateProject(Project project, int projectId)
    {
        Project project1=projectRep.findById(projectId).orElse(null);

        if(project1 == null)
        {
            return 0;
        }

        project1.setProjectName(project.getProjectName());
        return 1;
    }

    public int deleteProject(Project project)
    {
        if(projectRep.findById(project.getId()).isEmpty())
        {
            return 0;
        }

        simpleDeleteProject(project);  // This is a method in this class

        return 1;
    }

    public int simpleDeleteProject(Project project)   // To the facilitate unit testing
    {
        projectRep.delete(project);
        for(ProjectProduct projectProduct:project.getProjectProduct()){
            ppRepository.delete(projectProduct);
        }
        return 1;
    }

    public int simpleDeleteProjectProduct(ProjectProduct pp) // To the facilitate unit testing
    {
        ppRepository.delete(pp);
        return 1;
    }

}
