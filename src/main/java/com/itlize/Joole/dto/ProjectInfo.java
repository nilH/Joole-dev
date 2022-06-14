package com.itlize.Joole.dto;

import java.util.List;

public class ProjectInfo {
    private String name;
    private Integer id;
    private List<Integer> productIds;
    private List<String> productNames;

    public ProjectInfo(){}
    public ProjectInfo(Integer id, String name, List<Integer> productIds, List<String> productNames){
        this.id=id;
        this.name=name;
        this.productIds=productIds;
        this.productNames=productNames;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Integer> getProductIds() {
        return productIds;
    }
    public void setProductIds(List<Integer> productIds) {
        this.productIds = productIds;
    }
    public List<String> getProductNames() {
        return productNames;
    }
    public void setProductNames(List<String> productNames) {
        this.productNames = productNames;
    }
    
}
