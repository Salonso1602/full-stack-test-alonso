package com.api.repository.repositories.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.repository.entities.entityImplementations.EmployeeEntity;

@Repository
public interface IEmployeeRepository extends ListCrudRepository<EmployeeEntity, String> {

    @Query(
        value = "Select * FROM employees e WHERE e.manager_employee_id = :managerId",
        nativeQuery = true
    )
    public List<EmployeeEntity> findByManager(@Param("managerId")String managerId);

    @Query(
        value = "Select * FROM employees e WHERE e.matrix_manager_employee_id = :matrixManagerId",
        nativeQuery = true
    )
    public List<EmployeeEntity> findByMatrixManager(@Param("matrixManagerId")String matrixManagerId);

    @Query(
        value = "SELECT e.* FROM employees e WHERE e.employee_id IN (SELECT DISTINCT e2.manager_employee_id FROM employees e2 WHERE e2.manager_employee_id IS NOT NULL)",
        nativeQuery = true)
    public List<EmployeeEntity> findAllManagers();
}
