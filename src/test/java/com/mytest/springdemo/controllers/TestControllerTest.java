package com.mytest.springdemo.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testGetEmployeeById() throws Exception {
        mockMvc.perform(get("/employee/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("emp1"))
                .andExpect(jsonPath("$.designation").value("manager"));
    }

    @Test
    public void testGetEmployeeList() throws Exception {
        mockMvc.perform(get("/employee/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("emp1"))
                .andExpect(jsonPath("$[1].name").value("emp2"))
                .andExpect(jsonPath("$[2].name").value("emp3"));
    }
}