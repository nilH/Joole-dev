package com.itlize.Joole.userTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public class LoginTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void login() throws Exception{

        String username = "Oliver";
        String password = "12345";


        mockMvc.perform(post("/user/login").param(username, password));

    }




}
