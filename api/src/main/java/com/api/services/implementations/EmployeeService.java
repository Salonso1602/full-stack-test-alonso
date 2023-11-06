package com.api.services.implementations;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.api.models.Employee;
import com.api.services.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {

    @Override
    public ArrayList<Employee> getAllEmployees() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllEmployees'");
    }

    @Override
    public Employee getEmployeeById(String Id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmployeeById'");
    }

    @Override
    public Employee registerEmployee(Employee newEmployee) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registerEmployee'");
    }

    @Override
    public Employee deleteEmployee(String employeeId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteEmployee'");
    }
    
}
