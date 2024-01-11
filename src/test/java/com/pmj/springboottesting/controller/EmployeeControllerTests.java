package com.pmj.springboottesting.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pmj.springboottesting.model.Employee;
import com.pmj.springboottesting.service.EmployeeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class EmployeeControllerTests {
    @Autowired
    private MockMvc mockMvc;

    // MockBean annotation is used to add mock objects of EmployeeService class to the Spring application context.
    // So that inject into EmployeeController class.
    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("Junit test for createEmployee method")
    @Test
    public void givenEmployeeObject_whenCreateEmployee_thenReturnSavedEmployeeObject() {

        // given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Pramitha")
                .lastName("Jayasooriya")
                .email("lpramithamj@gmail.com")
                .build();

        // when - action or behavior that we are going test

        // then - verify the result or output using assert statements

    }
}
// 5:48