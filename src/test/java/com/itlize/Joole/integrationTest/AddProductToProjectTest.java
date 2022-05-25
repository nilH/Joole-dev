package com.itlize.Joole.integrationTest;

import com.itlize.Joole.entity.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class AddProductToProjectTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void register() throws Exception{
        new LoginTest().login();

        String productId = "3";
        String projectId = "1";


        mockMvc.perform(post("/project/add_Product_to_project").param(productId, projectId));

    }

}
