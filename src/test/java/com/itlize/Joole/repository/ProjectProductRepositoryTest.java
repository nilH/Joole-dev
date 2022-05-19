package com.itlize.Joole.repository;

import com.itlize.Joole.entity.Product;
import com.itlize.Joole.entity.Project;
import com.itlize.Joole.entity.ProjectProduct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProjectProductRepositoryTest {

    @Autowired
    ProjectProductRepository ppRepository;

    @Test
    void findByProject() {

        Project project = new Project();

        project.setProjectName("Zijie_project");

        Optional<ProjectProduct> pp = ppRepository.findByProject(project);

        assertThat(pp).isEmpty();

    }

    @Test
    void findByProduct() {

        Product product = new Product();

        product.setProductName("Zijie_product");

        Optional<ProjectProduct> pp = ppRepository.findByProduct(product);

        assertThat(pp).isEmpty();

    }
}