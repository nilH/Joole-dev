package com.itlize.Joole.repository;

import com.itlize.Joole.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query("select product from Product product where product.productName like %?1%")
    List<Product> findByProductNameContaining(String productName);
    List<Product> findByType(String type);
    List<Product> findByProductName(String productName);

    List<Product> findByUserTypeAndApplicationAndMountingLocationAndAccessoriesAndModelYearAndAirflowAndMaxPowerAndSoundAtMaxSpeedAndFanSweepDiameterAndHeight(String userType, String Application, String mountingLocation, String accessories, int modelYear, double airflow, double maxPower, double soundAtMaxSpeed, double fanSweepDiameter, double height);
}
