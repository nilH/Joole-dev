package com.itlize.Joole.repository;

import com.itlize.Joole.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByTypeIgnoreCaseContaining(String type);
    List<Product> findByUserTypeAndApplicationAndMountingLocationAndAccessoriesAndModelYearAndAirflowAndMaxPowerAndSoundAtMaxSpeedAndFanSweepDiameterAndHeight(String userType, String Application, String mountingLocation, String accessories, LocalDateTime modelYear, double airflow, double maxPower, double soundAtMaxSpeed, double fanSweepDiameter, double height);
}
