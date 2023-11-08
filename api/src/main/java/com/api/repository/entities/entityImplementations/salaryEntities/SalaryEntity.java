package com.api.repository.entities.entityImplementations.salaryEntities;

import com.api.repository.entities.entityImplementations.EmployeeEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity(name = "SALARIES")
public class SalaryEntity {
    
    @Id
    @Column(name = "employee_id")
    private String employeeId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;

    @Column(name = "pmr")
    private float pmr;

    @Column(name = "annual_salary")
    private float annualSalary;

    @Column(name = "ytd_commissions")
    private float ytdCommissions;

    @ManyToOne
    @JoinColumn(name = "compensation_grade_profile", referencedColumnName = "profile")
    private CompensationGradeProfileEntity compensationGrade;

    @ManyToOne
    @JoinColumn(name = "currency_id", referencedColumnName = "code")
    private CurrencyEntity currency;
}
