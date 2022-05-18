package com.itlize.Joole.controller;
//login register logout

import com.itlize.Joole.service.UserService;
import com.itlize.Joole.entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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
