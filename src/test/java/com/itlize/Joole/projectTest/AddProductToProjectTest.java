package com.itlize.Joole.projectTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public class AddProductToProjectTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void register() throws Exception{


        String productId = "3";
        String projectId = "1";


        mockMvc.perform(post("/project/addProduct").param(productId, projectId));

    }



}
