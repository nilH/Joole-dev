package com.itlize.Joole.integrationTest;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.hamcrest.core.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void login() throws Exception{

        String username = "username1";
        String password = "password";


        mockMvc.perform(get("/user/login").param("username",username).param("password",password))
                .andExpect(content().contentType(MediaType.valueOf("text/plain;charset=ISO-8859-1")));

    }




}
