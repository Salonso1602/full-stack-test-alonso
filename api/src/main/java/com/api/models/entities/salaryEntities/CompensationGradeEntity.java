package com.api.models.entities.salaryEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "COMPENSATION_GRADES")
public class CompensationGradeEntity {

    @Id
    @Column(name="grade")
    private String grade;

}
