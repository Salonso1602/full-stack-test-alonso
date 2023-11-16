package com.api.services.helpers.mappers;

import com.api.repository.entities.entityImplementations.EmployeeEntity;
import com.api.services.models.Employee;

public class EmployeeMapper extends BaseMapper<Employee, EmployeeEntity> {

    private SalaryMapper salMap = new SalaryMapper();
    private ContractMapper contrMap = new ContractMapper();

    @Override
    public Employee mapObject(EmployeeEntity ent) {
        return Employee.builder()
        .employeeId(ent.getEmployeeId())
        .firstName(ent.getFirstName())
        .middleName(ent.getMiddleName())
        .lastName(ent.getLastName())
        .email(ent.getEmail())
        .countryCode(ent.getCountryCode())
        .salary(salMap.mapObject(ent.getSalaryInfo()))
        .contract(contrMap.mapObject(ent.getContractInfo()))
        .build()
        ;
    }

    @Override
    public EmployeeEntity mapReverse(Employee mod) {
        return null;
    }
    
}
