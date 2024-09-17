package com.example.firstspringboot.controller;


import com.example.controller.ApiController;
import com.example.service.CurrencyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = ApiController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class ApiControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CurrencyService currencyService;

    @BeforeEach
    public void init() {

    }

    @Test
    public void ApiController_fetchData_ByTimeRange_ReturnedResponse() throws Exception {


    }
}
