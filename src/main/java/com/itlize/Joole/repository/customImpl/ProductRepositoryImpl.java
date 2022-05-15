package com.itlize.Joole.repository.customImpl;

import com.itlize.Joole.entity.Product;
import com.itlize.Joole.entity.ProductType;
import com.itlize.Joole.entity.TechnicalSpecs;
import com.itlize.Joole.repository.ProductRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Product> findByProductType(List<ProductType> productTypeList) {
        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery=criteriaBuilder.createQuery(Product.class);
        Root<Product> root=criteriaQuery.from(Product.class);
        List<Predicate> predicateList=new ArrayList<>();
        for(ProductType productType:productTypeList){
            Predicate predicate=criteriaBuilder.isMember(productType,root.get("productTypeList"));
            predicateList.add(predicate);
        }
        criteriaQuery.where(criteriaBuilder.and(predicateList.toArray(new Predicate[0])));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<Product> findByTechnicalSpecs(List<TechnicalSpecs> technicalSpecsList) {
        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery=criteriaBuilder.createQuery(Product.class);
        Root<Product> root=criteriaQuery.from(Product.class);
        List<Predicate> predicateList=new ArrayList<>();
        for(TechnicalSpecs technicalSpecs:technicalSpecsList){
            Predicate predicate=criteriaBuilder.isMember(technicalSpecs,root.get("technicalSpecsList"));
            predicateList.add(predicate);
        }
        criteriaQuery.where(criteriaBuilder.and(predicateList.toArray(new Predicate[0])));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<Product> findByProductTypeAndTechnicalSpecs(List<ProductType> productTypeList, List<TechnicalSpecs> technicalSpecsList) {
        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery=criteriaBuilder.createQuery(Product.class);
        Root<Product> root=criteriaQuery.from(Product.class);
        List<Predicate> predicateList=new ArrayList<>();
        for(ProductType productType:productTypeList){
            Predicate predicate=criteriaBuilder.isMember(productType,root.get("productTypeList"));
            predicateList.add(predicate);
        }
        for(TechnicalSpecs technicalSpecs:technicalSpecsList){
            Predicate predicate=criteriaBuilder.isMember(technicalSpecs,root.get("technicalSpecsList"));
            predicateList.add(predicate);
        }
        criteriaQuery.where(criteriaBuilder.and(predicateList.toArray(new Predicate[0])));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
