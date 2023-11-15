package com.api.repository.entities.entityImplementations.salaryEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "COMPENSATION_GRADE_PROFILES")

@NoArgsConstructor
@AllArgsConstructor
public class CompensationGradeProfileEntity {

    @Id
    @Column(name="profile", nullable = false)
    
    private String profile;

    @ManyToOne
    @JoinColumn(name="grade", referencedColumnName = "grade")
    private CompensationGradeEntity grade;

}
