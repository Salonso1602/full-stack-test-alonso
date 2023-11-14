package com.api.repository.entities.entityImplementations.contractEntities;

import java.util.Date;

import com.api.repository.entities.entityImplementations.EmployeeEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity(name = "CONTRACTS")
@Data
@Builder

@NoArgsConstructor
@AllArgsConstructor
public class ContractEntity {

    @Id
    @Column(name = "employee_id", nullable = false)
    
    private String employeeId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "employee_id")
    
    private EmployeeEntity employee;
    
    
    @OneToOne
    @JoinColumn(name="job_profile_id", referencedColumnName = "profile", nullable = false)
    private JobProfileEntity jobProfile;

    @Column(name = "hire_date")
    private Date hireDate;

    
    @ManyToOne
    @JoinColumn(name="type", referencedColumnName = "employee_type", nullable = false)
    private EmployeeTypeEntity type;

    
    @ManyToOne
    @JoinColumn(name="time_type", referencedColumnName = "time_type", nullable = false)
    private TimeTypeEntity timeType;

    
    @ManyToOne
    @JoinColumn(name="cost_center_id", referencedColumnName = "id", nullable = false)
    private CostCenterEntity costCenter;
}
