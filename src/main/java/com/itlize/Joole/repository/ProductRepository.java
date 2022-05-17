package com.itlize.Joole.repository;

import com.itlize.Joole.entity.Category;
import com.itlize.Joole.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>,ProductRepositoryCustom {
    List<Product> findByCategoryCategoryIdAndTypeIgnoreCaseContaining(int categoryId, String type);
}
