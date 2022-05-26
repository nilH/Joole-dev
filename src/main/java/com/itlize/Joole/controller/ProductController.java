package com.itlize.Joole.controller;

import com.itlize.Joole.entity.Product;
import com.itlize.Joole.entity.Project;
import com.itlize.Joole.service.ProductService;
import com.itlize.Joole.service.ProjectProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    ProjectProductService projectProductService;
    @PostMapping(value = "/add_product")
    public int addProduct(@RequestBody Product product){
        productService.addProduct(product);
        return 1;
    }

    @PostMapping(value = "/delete_product")
    public int deleteProduct(@RequestBody Product product){
        productService.deleteProduct(product);
        return 1;
    }

    @GetMapping(value = "/search_by_type")
    public List<Product> searchByType(@RequestParam("type") String type){
        List<Product> result=productService.searchByType(type);
        return result;
    }

    @GetMapping(value = "/product_filter")
    public List<Product> Filter(@RequestParam("user_type") String userType, @RequestParam("application")  String application, @RequestParam("mounting_location") String mountingLocation,
                                @RequestParam("accessories") String accessories, @RequestParam("modelYear") String modelYear, @RequestParam("airflow") double airflow,
                                @RequestParam("max_power") double maxPower, @RequestParam("sound_at_max_speed") double soundAtMaxSpeed,
                                @RequestParam("fan_sweep_diameter") double fanSweepDiameter, @RequestParam("height") double height){
        List<Product> result = productService.filter(userType,  application,  mountingLocation,  accessories,  Integer.parseInt(modelYear),  airflow,  maxPower,  soundAtMaxSpeed,  fanSweepDiameter,  height);
        return result;
    }

    @PostMapping(value = "/update_product")
    public int updateProduct(@RequestBody Product product,@RequestParam("product_id") Integer productId){
        productService.updateProduct(product, productId);
        return 1;
    }

    @GetMapping(value = "/findall_product")
    public List<Product> findAllProduct() {
        List<Product> result = productService.findAllProduct();
        return result;
    }

    @GetMapping(value = "/findby_productid")
    public Product findById(@RequestParam("product_id") Integer productId){
        Product result = productService.findById(productId);
        return result;
    }

    @GetMapping(value = "/findby_productname")
    public List<Product> findByName(@RequestParam("product_name") String productName){
        List<Product> result = productService.findByName(productName);
        return result;
    }

    @GetMapping(value = "/get_project_from_product")
    public List<Project> getProjectFromProduct(@RequestBody Product product){
        List<Project> result = projectProductService.getProjectFromProduct(product);
        return result;

    }

}
