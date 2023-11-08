package com.api.models.entities.contractEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class EmployeeTypeEntity {

    @Id
    @Column(name="employee_type")
    private String employeeType;

}
