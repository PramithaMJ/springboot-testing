package com.pmj.springboottesting.repositry;

import com.pmj.springboottesting.model.Employee;
import com.pmj.springboottesting.repository.EmployeeRepository;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class EmployeeRepositoryTests {
    @Autowired
    private EmployeeRepository employeeRepository;

    // Junit test for save employee operation
    //@DisplayName("Junit test for save employee operation")
    @Test
    public void givenEmployeeObject_whenSave_thenReturnSavedEmployee() {

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

    //Junit test for get all the employees operation
    @DisplayName("Junit test for get all the employees operation")
    @Test
    public void givenEmployeesList_whenFindAll_thenEmployeesList() {
        // given recondition or setup
        Employee employee = Employee.builder()
                .firstName("Pramitha")
                .lastName("Jayasooriya")
                .email("lpramithamj@gmail.com")
                .build();

        Employee employee1 = Employee.builder()
                .firstName("Mihiranga")
                .lastName("Jayasooriya")
                .email("mihiranga@gmail.com")
                .build();

        employeeRepository.save(employee);
        employeeRepository.save(employee1);

        //when - action or the behavior that we are going to test

        List<Employee> employeeList = employeeRepository.findAll();

        //then - verify the output
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(2);
    }

    //Junit test for get employee by id operation
    @DisplayName("Junit test for get employee by id operation")
    @Test
    public void givenEmployeeObject_whenFindById_thenReturnEmployeeObject() {
        // given recondition or setup
        Employee employee = Employee.builder()
                .firstName("Pramitha")
                .lastName("Jayasooriya")
                .email("lpramithamj@gmail.com")
                .build();

        employeeRepository.save(employee);

        //when - action or the behavior that we are going to test

        Employee employeeDB = employeeRepository.findById(employee.getId()).get();

        //then - verify the output
        assertThat(employeeDB).isNotNull();

    }

    //Junit test for get employee by email operation
    @DisplayName("Junit test for get employee by email operation")
    @Test
    public void givenEmployeeEmail_whenFindByEmail_thenReturnEmployeeObject() {
        // given recondition or setup
        Employee employee = Employee.builder()
                .firstName("Pramitha")
                .lastName("Jayasooriya")
                .email("lpramithamj@gmail.com")
                .build();

        employeeRepository.save(employee);

        //when - action or the behavior that we are going to test
        Employee employeeDB = employeeRepository.findByEmail(employee.getEmail()).get();

        //then - verify the output
        assertThat(employeeDB).isNotNull();
    }

    //Junit test for update employee object
    @DisplayName("Junit test for update employee object")
    @Test
    public void givenEmployeeObject_whenUpdateEmployee_thenReturnUpdatedEmployee() {
        // given recondition or setup
        Employee employee = Employee.builder()
                .firstName("Pramitha")
                .lastName("Jayasooriya")
                .email("lpramithamj@gmail.com")
                .build();
        employeeRepository.save(employee);

        //when - action or the behavior that we are going to test
        Employee savedEmployee = employeeRepository.findById(employee.getId()).get();
        savedEmployee.setEmail("mihiranga@gmail.com");
        savedEmployee.setFirstName("Mihiranga");
        Employee updatedEmployee = employeeRepository.save(savedEmployee);

        //then - verify the output
        assertThat(updatedEmployee.getEmail()).isEqualTo("mihiranga@gmail.com");
        assertThat(updatedEmployee.getFirstName()).isEqualTo("Mihiranga");

    }

    //Junit test for delete employee operation
    @DisplayName("Junit test for delete employee operation")
    @Test
    public void givenEmployeeObject_whenDelete_thenRemoveEmployee() {
        // given recondition or setup
        Employee employee = Employee.builder()
                .firstName("Pramitha")
                .lastName("Jayasooriya")
                .email("lpramithamj@gmail.com")
                .build();

        //when - action or the behavior that we are going to test
        employeeRepository.deleteById(employee.getId());
        Optional<Employee> employeeOptional = employeeRepository.findById(employee.getId());

        //then - verify the output
        assertThat(employeeOptional).isEmpty();
    }

    //Junit test for custom query using JPQL with index
    @DisplayName("Junit test for custom query using JPQL with index")
    @Test
    public void givenFirstNameAndLastName_whenFindByJPQL_thenReturnEmployeeObject() {
        // given recondition or setup
        Employee employee = Employee.builder()
                .firstName("Pramitha")
                .lastName("Jayasooriya")
                .email("lpramithamj@gmail.com")
                .build();
        employeeRepository.save(employee);
        String firstName = "Pramitha";
        String lastName = "Jayasooriya";

        //when - action or the behavior that we are going to test
        Employee savedEmployee = employeeRepository.findByJPQL(firstName, lastName);

        //then - verify the output
        assertThat(savedEmployee).isNotNull();

    }

    //Junit test for custom query using JPQL with Named params
    @DisplayName("Junit test for custom query using JPQL Named params")
    @Test
    public void givenFirstNameAndLastName_whenFindByJPQLNamedParams_thenReturnEmployeeObject() {
        // given recondition or setup
        Employee employee = Employee.builder()
                .firstName("Pramitha")
                .lastName("Jayasooriya")
                .email("lpramithamj@gmail.com")
                .build();
        employeeRepository.save(employee);
        String firstName = "Pramitha";
        String lastName = "Jayasooriya";

        //when - action or the behavior that we are going to test
        Employee savedEmployee = employeeRepository.findByJPQLNamedParams(firstName, lastName);

        //then - verify the output
        assertThat(savedEmployee).isNotNull();

    }

}