package com.api.helpers.mappers;

import com.api.helpers.IEntityMapper;
import com.api.repository.entities.entityImplementations.EmployeeEntity;
import com.api.repository.entities.entityImplementations.contractEntities.CostCenterEntity;
import com.api.repository.entities.entityImplementations.contractEntities.JobProfileEntity;
import com.api.services.models.CostCenter;
import com.api.services.models.Employee;
import com.api.services.models.JobProfile;

public class EmployeeMapper extends BaseMapper<Employee, EmployeeEntity> {

    private IEntityMapper<JobProfile,JobProfileEntity> jobProfMapper = new JobProfileMapper();
    private IEntityMapper<CostCenter,CostCenterEntity> costCenterMapper = new CostCenterMapper();

    @Override
    public Employee mapObject(EmployeeEntity ent) {
        return Employee.builder()
        .employeeId(ent.getEmployeeId())
        .firstName(ent.getFirstName())
        .middleName(ent.getMiddleName())
        .lastName(ent.getLastName())
        .email(ent.getEmail())
        .type(ent.getContractInfo().getType().getEmployeeType())
        .timeType(ent.getContractInfo().getTimeType().getTimeType())
        .jobProfile(jobProfMapper.mapObject(ent.getContractInfo().getJobProfile()))
        .hireDate(ent.getContractInfo().getHireDate())
        .costCenter(costCenterMapper.mapObject(ent.getContractInfo().getCostCenter()))
        .countryCode(ent.getCountryCode())
        .build()
        ;
    }

    @Override
    public EmployeeEntity mapReverse(Employee mod) {
        return null;
    }
    
}
