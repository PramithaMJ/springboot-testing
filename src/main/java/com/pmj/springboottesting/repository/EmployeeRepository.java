package com.pmj.springboottesting.repository;

import com.pmj.springboottesting.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//Dao
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Optional<Employee> findByEmail(String email);
}
