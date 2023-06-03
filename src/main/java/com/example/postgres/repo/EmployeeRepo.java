package com.example.postgres.repo;


import com.example.postgres.repo.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepo extends org.springframework.data.repository.Repository<Employee,Long> {
    List<Employee> getEmployeeByFirstNameAndLastNameAndEmailId(String firstname,String lastname,String emailid);
    List<Employee> getEmployeeByFirstName(String firstname);
    List<Employee> getEmployeeByLastName(String lastname);
    List<Employee> findAll();
    Employee save(Employee emp);




}
