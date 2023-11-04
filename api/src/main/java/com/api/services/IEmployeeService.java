package com.api.services;

import java.util.ArrayList;

import com.api.models.Employee;

public interface IEmployeeService {
    public ArrayList<Employee> getAllEmployees();
    public Employee getEmployeeById();
    public Employee registerEmployee(Employee newEmployee);
}
