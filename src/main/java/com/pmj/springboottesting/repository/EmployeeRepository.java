package com.pmj.springboottesting.repository;

import com.pmj.springboottesting.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//Dao
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
