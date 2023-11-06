package com.api.services;

import java.util.List;

import com.api.models.Employee;

public interface IEmployeeService {
    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(String Id);
    public Employee registerEmployee(Employee newEmployee);
    public Employee deleteEmployee(String employeeId);
}
