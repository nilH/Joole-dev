package com.itlize.Joole.repository;

import com.itlize.Joole.entity.Product;
import com.itlize.Joole.entity.Project;
import com.itlize.Joole.entity.ProjectProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectProductRepository extends JpaRepository<ProjectProduct,Integer> {

    Optional<ProjectProduct> findByProject (Project project);

    Optional<ProjectProduct> findByProduct(Product product);

    @Override
    <S extends ProjectProduct> S save(S entity);
}
