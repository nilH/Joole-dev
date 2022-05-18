package com.itlize.Joole.service;

import com.itlize.Joole.entity.Project;
import com.itlize.Joole.entity.ProjectProduct;
import com.itlize.Joole.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class ProjectManage {

    @Autowired ProjectRepository projectRep;

    public int addProductToProject(int productId, int projectId)
    {
        Set<ProjectProduct> ppSet = new HashSet<ProjectProduct>();

        Project project = projectRep.findByproject_id(projectId);

        ProjectProduct pp = new ProjectProduct();

        pp.setProject(project);

        ppSet.add(pp);

        project.setProjectProduct(ppSet);

        return 1;

    }
}
