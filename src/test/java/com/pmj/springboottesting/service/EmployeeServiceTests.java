package com.pmj.springboottesting.service;

import com.pmj.springboottesting.model.Employee;
import com.pmj.springboottesting.repository.EmployeeRepository;
import com.pmj.springboottesting.service.impl.EmployeeServiceIMPL;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.util.Optional;

public class EmployeeServiceTests {
    private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;

    @BeforeEach
    public void setup() {

        employeeRepository = Mockito.mock(EmployeeRepository.class);
        employeeService = new EmployeeServiceIMPL(employeeRepository);

    }

    //Junit test for saveEmployee method
    @DisplayName("Junit test for saveEmployee method")
    @Test
    public void givenEmployeeObject_whenSavedEmployee_thenReturnEmployeeObject() {
        // given recondition or setup
        Employee employee = Employee.builder()
                .id(1L)
                .firstName("Pramitha")
                .lastName("Jayasooriya")
                .email("lpramithamj@gmail.com")
                .build();

        BDDMockito.given(employeeRepository.findByEmail(employee.getEmail())).willReturn(Optional.empty());

        BDDMockito.given(employeeRepository.save(employee)).willReturn(employee);

        System.out.println(employeeRepository);
        System.out.println(employeeService);

        //when - action or the behavior that we are going to test
        Employee savedEmployee = employeeService.saveEmployee(employee);

        System.out.println(savedEmployee);

        //then - verify the output
        Assertions.assertThat(savedEmployee).isNotNull();
    }
}
