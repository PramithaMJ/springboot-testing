package com.pmj.springboottesting.repository;

import com.pmj.springboottesting.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

//Dao
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Optional<Employee> findByEmail(String email);

    //define custom query using JPQL with index params
    @Query("select e from Employee e where e.firstName =?1 and e.lastName = ?2")
    Employee findByJPQL(String firstName,String lastName);

    //define custom query using JPQL with named params
    @Query("select e from Employee e where e.firstName =:firstName and e.lastName =:lastName")
    Employee findByJPQLNamedParams(@Param("firstName") String firstName,@Param("lastName") String lastName);
}
