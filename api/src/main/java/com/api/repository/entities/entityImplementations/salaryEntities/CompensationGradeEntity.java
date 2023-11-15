package com.api.repository.entities.entityImplementations.salaryEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "COMPENSATION_GRADES")

@NoArgsConstructor
@AllArgsConstructor
public class CompensationGradeEntity {

    @Id
    @Column(name="grade", nullable = false)
    
    private String grade;

}
