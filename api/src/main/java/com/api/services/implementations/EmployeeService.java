package com.api.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.helpers.IEntityMapper;
import com.api.helpers.mappers.EmployeeMapper;
import com.api.repository.entities.entityImplementations.EmployeeEntity;
import com.api.repository.repositories.interfaces.IEmployeeRepository;
import com.api.services.interfaces.IEmployeeService;
import com.api.services.models.Employee;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository repo;

    private IEntityMapper<Employee, EmployeeEntity> mapper = new EmployeeMapper();

    @Override
    public List<Employee> getAllEmployees() {
        return mapper.mapObjects(repo.findAll());
    }

    @Override
    public Employee getEmployeeById(String Id) {
        return mapper.mapObject(repo.findById(Id).get());
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

    @Override
    public List<Employee> getEmployeesByManager(String managerId) {
        return mapper.mapObjects(repo.findByManager(managerId).values());
    }

    @Override
    public List<Employee> getEmployeesByMatrixManager(String matrixManagerId) {
        return mapper.mapObjects(repo.findByMatrixManager(matrixManagerId).values());
    }
    
}
