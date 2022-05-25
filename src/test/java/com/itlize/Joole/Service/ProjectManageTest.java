package com.itlize.Joole.Service;

import com.itlize.Joole.entity.Product;
import com.itlize.Joole.entity.Project;
import com.itlize.Joole.entity.ProjectProduct;
import com.itlize.Joole.entity.User;
import com.itlize.Joole.repository.ProductRepository;
import com.itlize.Joole.repository.ProjectProductRepository;
import com.itlize.Joole.repository.ProjectRepository;
import com.itlize.Joole.service.MyUserDetailService;
import com.itlize.Joole.service.ProjectService;
import com.itlize.Joole.service.serviceImpl.ProjectServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProjectManageTest {

    @Mock
    ProductRepository productRepository;
    @Mock
    ProjectRepository projectRep;
    @Mock
    ProjectProductRepository ppRepository;

    @Autowired
    @InjectMocks
    private ProjectServiceImpl projectServiceImp;
    private Product product;

    private Project project;

    ProjectProduct pp;

    @BeforeEach
    public void setUp() {
        Set<ProjectProduct> ppSet = new HashSet<ProjectProduct>();
        product = new Product();
        product.setProductName("A");
        product.setProductId(1);
        project = new Project();
        project.setProjectName("B");
        project.setId(2);
        pp = new ProjectProduct();
        ppSet.add(pp);
        pp.setProduct(product);
        pp.setProject(project);
        project.setProjectProduct(ppSet);
        product.setProjectProductSet(ppSet);
    }



    @Test
    public void addProductToProjectTest()
    {
        when(productRepository.findById(any())).thenReturn(Optional.ofNullable(product));
        when(projectRep.findById(any())).thenReturn(Optional.ofNullable(project));
        when(ppRepository.save(any())).thenReturn(pp);

        assertThat(projectServiceImp.addProductToProject(1,2)).isEqualTo(1);
    }
}