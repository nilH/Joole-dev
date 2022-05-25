package com.itlize.Joole.controller;

//add product to project

import com.itlize.Joole.entity.Product;
import com.itlize.Joole.entity.Project;
import com.itlize.Joole.entity.ProjectProduct;
import com.itlize.Joole.service.serviceImpl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectServiceImpl manage;

    @PostMapping("/add_product_to_project")
    public int addProductToProject(@RequestParam("product_id") Integer productId,@RequestParam("project_id") Integer projectId)
    {
        manage.addProductToProject(productId, projectId);
        return 1;
    }

    @PostMapping("/delete_product_from_project")
    public int deleteProductFromProject(@RequestParam("product_id") Integer productId,@RequestParam("project_id") Integer projectId)
    {
        manage.deleteProductFromProject(productId, projectId);
        return 1;
    }

    @GetMapping("/get_product_from_project")
    public List<Product> getProductFromProject(@RequestParam("project_id") int projectId)
    {
        List<Product> result = manage.getProductFromProject(projectId);
        return result;
    }

    @PostMapping(value = "/add_project")
    public int addProject(@RequestBody Project project){
        manage.addProject(project);
        return 1;
    }

    @PostMapping(value = "/delete_project")
    public int deleteProject(@RequestBody Project project){
        manage.deleteProject(project);
        return 1;
    }

    @PostMapping(value = "/update_project")
    public int updateProject(@RequestBody Project project,@RequestParam("project_id") Integer projectId){
        manage.updateProject(project, projectId);
        return 1;
    }

    @GetMapping(value = "/findall_project")
    public List<Project> findAllProject() {
        List<Project> result = manage.findAllProject();
        return result;
    }

    @GetMapping(value = "/findby_projectid")
    public Project findById(@RequestParam("project_id") Integer projectId){
        Project result = manage.findById(projectId);
        return result;
    }

    @GetMapping(value = "/findby_projectname")
    public List<Project> findByName(@RequestParam("project_name") String projectName){
        List<Project> result = manage.findByName(projectName);
        return result;
    }

}
