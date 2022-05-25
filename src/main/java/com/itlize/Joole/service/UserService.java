package com.itlize.Joole.service;

import com.itlize.Joole.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    User findByUsername(String username);
    List<User> findAllUsers();
    boolean create(User user);
    boolean delete(User user);
    boolean update(String userName, User user);
    void clear();
}
