package com.demo.unittestdemo.service;

import com.demo.unittestdemo.entity.Employee;
import com.demo.unittestdemo.interfaces.EmployeeServiceInterface;
import com.demo.unittestdemo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements EmployeeServiceInterface {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {

        Optional<Employee> savedEmployee = employeeRepository.findByEmail(employee.getEmail());
        if (savedEmployee.isPresent()) {
            throw new RuntimeException("Employee already exist with given email:" + employee.getEmail());
        }
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(RuntimeException::new);

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }
}
