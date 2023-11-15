package com.api.repository.entities.entityImplementations.contractEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity

@NoArgsConstructor
@AllArgsConstructor
public class EmployeeTypeEntity {

    @Id
    @Column(name="employee_type", nullable = false)
    
    private String employeeType;

}
