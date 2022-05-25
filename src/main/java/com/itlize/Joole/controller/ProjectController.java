package com.itlize.Joole.controller;

//add product to project

import com.itlize.Joole.service.serviceImpl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectServiceImpl manage;

    @PostMapping("/addProduct")
    public int addProduct(@RequestParam("productId") int productId,@RequestParam("projectId") int projectId)
    {
        manage.addProductToProject(productId, projectId);
        return 1;
    }

}
