package com.api.repository.entities.entityImplementations.salaryEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "COMPENSATION_GRADE_PROFILES")
public class CompensationGradeProfileEntity {

    @Id
    @Column(name="profile")
    private String profile;

    @ManyToOne
    @JoinColumn(name="grade", referencedColumnName = "grade")
    private CompensationGradeEntity grade;

}
