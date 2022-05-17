package com.itlize.Joole.repository;

import com.itlize.Joole.entity.TechnicalSpecs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalSpecsRepository extends JpaRepository<TechnicalSpecs,Integer> {
}
