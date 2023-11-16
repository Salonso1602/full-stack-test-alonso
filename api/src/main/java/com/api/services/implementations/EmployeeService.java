package com.api.services.implementations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.repository.entities.entityImplementations.EmployeeEntity;
import com.api.repository.repositories.interfaces.IEmployeeRepository;
import com.api.services.helpers.IEntityMapper;
import com.api.services.helpers.mappers.EmployeeMapper;
import com.api.services.interfaces.IEmployeeService;
import com.api.services.models.Employee;
import com.api.services.models.ManagerDependants;

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
        return mapper.mapObjects(repo.findByManager(managerId));
    }

    @Override
    public List<Employee> getEmployeesByMatrixManager(String matrixManagerId) {
        return mapper.mapObjects(repo.findByMatrixManager(matrixManagerId));
    }

    @Override
    public List<ManagerDependants> getEmployeesByManager() {
        List<ManagerDependants> mangs = new ArrayList<>();

        Iterator<EmployeeEntity> iter = repo.findAllManagers().iterator();

        while (iter.hasNext()) {
            EmployeeEntity emp = iter.next();
            mangs.add(new ManagerDependants(mapper.mapObject(emp), mapper.mapObjects(emp.getDependants())));
        }
        return mangs;
    }
    
}
