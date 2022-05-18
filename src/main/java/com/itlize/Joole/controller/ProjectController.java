package com.itlize.Joole.controller;

//add product to project

import com.itlize.Joole.service.ProjectManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectManage manage;

    @PostMapping("/addProduct")
    public int addProduct(@RequestParam("productId") int productId,@RequestParam("projectId") int projectId)
    {
        this.addProduct(productId, projectId);
        return 1;
    }

}
