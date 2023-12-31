package com.pmj.springboottesting.service;

import com.pmj.springboottesting.exception.ResourceNotFoundException;
import com.pmj.springboottesting.model.Employee;
import com.pmj.springboottesting.repository.EmployeeRepository;
import com.pmj.springboottesting.service.impl.EmployeeServiceIMPL;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTests {
    @Mock
    private EmployeeRepository employeeRepository;
    @InjectMocks
    private EmployeeServiceIMPL employeeService;

    private Employee employee;

    @BeforeEach
    public void setup() {

        // employeeRepository = Mockito.mock(EmployeeRepository.class);
        // employeeService = new EmployeeServiceIMPL(employeeRepository);

        // given recondition or setup
        employee = Employee.builder()
                .id(1L)
                .firstName("Pramitha")
                .lastName("Jayasooriya")
                .email("lpramithamj@gmail.com")
                .build();

    }

    //Junit test for saveEmployee method
    @DisplayName("Junit test for saveEmployee method")
    @Test
    public void givenEmployeeObject_whenSavedEmployee_thenReturnEmployeeObject() {
        // given recondition or setup

        given(employeeRepository.findByEmail(employee.getEmail())).willReturn(Optional.empty());

        given(employeeRepository.save(employee)).willReturn(employee);

        System.out.println(employeeRepository);
        System.out.println(employeeService);

        //when - action or the behavior that we are going to test
        Employee savedEmployee = employeeService.saveEmployee(employee);

        System.out.println(savedEmployee);

        //then - verify the output
        Assertions.assertThat(savedEmployee).isNotNull();
    }

    //Junit test for saveEmployee method which throws exception
    @DisplayName("Junit test for saveEmployee method which throws exception")
    @Test
    public void givenExistingEmail_whenSavedEmployee_thenThrowsException() {
        // given recondition or setup

        given(employeeRepository.findByEmail(employee.getEmail())).willReturn(Optional.of(employee));

        System.out.println(employeeRepository);
        System.out.println(employeeService);

        //when - action or the behavior that we are going to test
        org.junit.jupiter.api.Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            employeeService.saveEmployee(employee);
        });

        // then
        verify(employeeRepository, never()).save(any(Employee.class));
    }

    //Junit test for getAllEmployees method
    @DisplayName("Junit test for getAllEmployees method")
    @Test
    public void givenEmployeeList_whenGetAllEmployees_thenReturnEmployeesList() {
        // given recondition or setup

        Employee employee1 = Employee.builder()
                .id(2L)
                .firstName("Mihiranga")
                .lastName("PM")
                .email("mihiranga@gmail.com")
                .build();

        given(employeeRepository.findAll()).willReturn(List.of(employee,employee1));

        //when - action or the behavior that we are going to test

        List<Employee> employeeList = employeeService.getAllEmployees();

        //then - verify the output

        Assertions.assertThat(employeeList).isNotNull();
        //Assertions.assertThat(employeeList).hasSize(2);
        Assertions.assertThat(employeeList.size()).isEqualTo(2);

    }

    //Junit test for getAllEmployees method (negative scenario)
    @DisplayName("Junit test for getAllEmployees method (negative scenario)")
    @Test
    public void givenEmptyEmployeeList_whenGetAllEmployees_thenReturnEmptyEmployeesList() {
        // given recondition or setup

        Employee employee1 = Employee.builder()
                .id(2L)
                .firstName("Mihiranga")
                .lastName("PM")
                .email("mihiranga@gmail.com")
                .build();

        given(employeeRepository.findAll()).willReturn(Collections.emptyList());

        //when - action or the behavior that we are going to test

        List<Employee> employeeList = employeeService.getAllEmployees();

        //then - verify the output

        Assertions.assertThat(employeeList).isEmpty();
        Assertions.assertThat(employeeList.size()).isEqualTo(0);

    }

}
