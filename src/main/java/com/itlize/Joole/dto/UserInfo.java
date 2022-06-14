package com.itlize.Joole.dto;

import java.util.List;

public class UserInfo {
    private String username;
    private String token;
    private String password;
    private List<Integer> projectIds;
    private List<String> projectNames;

    public UserInfo(){}
    
    public UserInfo(String username,String password, String token, List<Integer> projectIds, List<String> projectNames){
        this.username=username;
        this.password=password;
        this.token=token;
        this.projectIds=projectIds;
        this.projectNames=projectNames;
    }

    public UserInfo(String username, String password){
        this.username=username;
        this.password=password;
    }
  
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<Integer> getProjectIds() {
        return projectIds;
    }
    public void setProjectIds(List<Integer> projectIds) {
        this.projectIds = projectIds;
    }
    public List<String> getProjectNames() {
        return projectNames;
    }
    public void setProjectNames(List<String> projectNames) {
        this.projectNames = projectNames;
    }
}
