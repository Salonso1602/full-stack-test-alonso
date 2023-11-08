package com.api.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.repository.entities.entityImplementations.EmployeeEntity;

@Repository
public interface IEmployeeRepository extends ListCrudRepository<EmployeeEntity, String> {

    @Query(
        value = "Select * FROM EMPLOYEES e WHERE e.manager_employee_id = :managerId",
        nativeQuery = true
    )
    public Map<String, EmployeeEntity> findByManager(@Param("managerId")String managerId);

    @Query(
        value = "Select * FROM EMPLOYEES e WHERE e.matrix_manager_employee_id = :matrixManagerId",
        nativeQuery = true
    )
    public Map<String, EmployeeEntity> findByMatrixManager(@Param("matrixManagerId")String matrixManagerId);
}
