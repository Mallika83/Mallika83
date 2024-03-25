package com.springboot.sampleappadd;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.sampleappadd.Model.Inputs;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.springboot.sampleappadd.Controller.addController;
import com.springboot.sampleappadd.Service.addService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers= {addController.class},excludeAutoConfiguration = {SecurityAutoConfiguration.class})

public class AddControllerTest {


    @MockBean
    addService service;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before()
    public void setup()
    {
        //Init MockMvc Object and build
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void addNumbersTest() throws Exception{
        Inputs inputsTest = new Inputs(456f,899f);

        when(service.addNumbers(inputsTest)).thenReturn(1355f);

        mockMvc.perform(post("/addNumbers").with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(inputsTest))
                )
                .andExpect(status().isOk());


    }

}
