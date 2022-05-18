package com.itlize.Joole.service.serviceImpl;

import com.itlize.Joole.entity.User;
import com.itlize.Joole.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService{

    @Autowired UserRepository userR;


    public int login(String username, String password)
    {
        return 1;
    }

    public int logout(String username)
    {
        return 1;
    }

    public int register(String username, String password)
    {
        User user = new User();

        user.setName(username);

        user.setPassword(password);

        userR.save(user);

        return 1;
    }

}
