package com.itlize.Joole.controller;
//login register logout

import com.itlize.Joole.service.serviceImpl.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/login")
    public int login(@RequestParam("username") String username,
                     @RequestParam("password") String password)
    {
        this.service.login(username, password);

        return 1;
    }

    @PostMapping("/register")
    public int register(@RequestParam("username") String username,
                     @RequestParam("password") String password)
    {
        this.service.register(username, password);

        return 1;
    }

    @PostMapping("/logout")
    public int logout(@RequestParam("username") String username)
    {
        this.service.logout(username);

        return 1;
    }
    

}
