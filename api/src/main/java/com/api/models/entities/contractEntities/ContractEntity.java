package com.api.models.entities.contractEntities;

import java.util.Date;

import com.api.models.entities.EmployeeEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity(name = "CONTRACTS")
public class ContractEntity {

    @Id
    @Column(name = "employee_id")
    private String employeeId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;
    
    @OneToOne
    @JoinColumn(name="job_profile_id", referencedColumnName = "profile")
    private JobProfileEntity jobProfile;

    @Column(name = "hire_date")
    private Date hireDate;

    @ManyToOne
    @JoinColumn(name="type", referencedColumnName = "employee_type")
    private EmployeeTypeEntity type;

    @ManyToOne
    @JoinColumn(name="time_type", referencedColumnName = "time_type")
    private TimeTypeEntity timeType;

    @ManyToOne
    @JoinColumn(name="cost_center_id", referencedColumnName = "id")
    private CostCenterEntity costCenter;
}
