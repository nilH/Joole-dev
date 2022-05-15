package com.itlize.Joole.repository;


import com.itlize.Joole.entity.Manufacturer;
import com.itlize.Joole.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {

    List<Manufacturer> findByName(String name);

    List<Manufacturer> findById(int id);

}
