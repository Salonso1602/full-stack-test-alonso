package com.api.repository;

import com.api.models.entities.EmployeeEntity;

import java.util.Map;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends ListCrudRepository<EmployeeEntity, String> {

    public Map<EmployeeEntity, EmployeeEntity> getEmployeeByManager(String managerId);
}
