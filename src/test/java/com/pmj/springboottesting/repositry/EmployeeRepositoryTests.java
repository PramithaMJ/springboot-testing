package com.pmj.springboottesting.repositry;

import com.pmj.springboottesting.model.Employee;
import com.pmj.springboottesting.repository.EmployeeRepository;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class EmployeeRepositoryTests {
    @Autowired
    private EmployeeRepository employeeRepository;

    // Junit test for save employee operation
    //@DisplayName("Junit test for save employee operation")
    @Test
    public void givenEmployeeObject_whenSave_thenReturnSavedEmployee(){

        //given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Pramitha")
                .lastName("Jayasooriya")
                .email("lpramithamj@gmail.com")
                .build();

        //when - action or the behavior that we are going to test
        Employee savedEmployee = employeeRepository.save(employee);

        //then - verify the output
        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getId()).isGreaterThan(0);
//        Assertions.assertThat(savedEmployee).isNotNull();
//        Assertions.assertThat(savedEmployee.getId()).isGreaterThan(0);
    }
}
