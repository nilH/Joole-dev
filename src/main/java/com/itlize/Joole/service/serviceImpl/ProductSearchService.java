package com.itlize.Joole.service.serviceImpl;

import com.itlize.Joole.entity.Product;
import com.itlize.Joole.repository.ProductRepository;
import com.itlize.Joole.service.ProductSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductSearchService implements ProductSearch {
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> searchByName(String name) {
        return productRepository.findByTypeIgnoreCaseContaining(name);
    }

    @Override
    public List<Product> filter(String userType, String application, String mountingLocation, String accessories, LocalDateTime modelYear, double airflow, double maxPower, double soundAtMaxSpeed, double fanSweepDiameter, double height) {
        return productRepository.findByUserTypeAndApplicationAndMountingLocationAndAccessoriesAndModelYearAndAirflowAndMaxPowerAndSoundAtMaxSpeedAndFanSweepDiameterAndHeight( userType,  application,  mountingLocation,  accessories,  modelYear,  airflow,  maxPower,  soundAtMaxSpeed,  fanSweepDiameter,  height);
    }
}
