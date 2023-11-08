package com.api.services.interfaces;

import java.util.List;


import com.api.services.models.Employee;

public interface IEmployeeService {
    public List<Employee> getAllEmployees();
    public List<Employee> getEmployeesByManager(String managerId);
    public List<Employee> getEmployeesByMatrixManager(String matrixManagerId);
    public Employee getEmployeeById(String Id);
    public Employee registerEmployee(Employee newEmployee);
    public Employee deleteEmployee(String employeeId);

}
