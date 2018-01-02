package com.poc.pocrestfulapi.service;

import com.poc.pocrestfulapi.model.Employee;

import java.util.List;

public interface EmployeeService {

    void create(Employee employee);

    Employee getEmployeeById(long id);

    List<Employee> getAllEmployees();
}