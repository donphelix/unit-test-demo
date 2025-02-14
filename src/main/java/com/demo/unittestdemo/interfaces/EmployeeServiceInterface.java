package com.demo.unittestdemo.interfaces;

import com.demo.unittestdemo.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeServiceInterface {
    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeById(long id);

    Employee updateEmployee(Employee employee, long id);

    void deleteEmployee(long id);
}
