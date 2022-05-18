package com.itlize.Joole.userTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public class RegisterTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void register() throws Exception{

        String username = "Oliver";
        String password = "12345";


        mockMvc.perform(post("/user/register").param(username, password));

    }



}
