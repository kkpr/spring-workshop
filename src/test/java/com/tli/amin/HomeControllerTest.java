package com.tli.amin;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

//@RunWith(SpringRunner.class)
//@WebMvcTest(value = HomeController.class,secure = false)
public class HomeControllerTest {

   // @Autowired
    private MockMvc mockMvc;

    @Ignore
    public void testIndex() throws Exception{
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("welcome"));
               // .andDo(print());
    }

    @Ignore
    public void testHome() throws Exception {
        mockMvc.perform(get("/home"))
                .andExpect(status().isOk())
        .andExpect(view().name("home/homeNotSignedIn"));
         //  .andExpect(containsString("home"));
    }
}