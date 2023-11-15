package com.api.repository.entities.entityImplementations;

import java.util.List;

import com.api.repository.entities.entityImplementations.contractEntities.ContractEntity;
import com.api.repository.entities.entityImplementations.salaryEntities.SalaryEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "EMPLOYEES")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeEntity {

    @Id
    @Column( name = "employee_id", updatable = false, nullable = false)
    
    private String employeeId;

    
    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "first_name", nullable = false)
    
    private String firstName;

    @Column(name = "middle_name" )
    private String middleName;

    @Column( name = "last_name" , nullable = false)
    
    private String lastName;

    @Column(name = "email", nullable = false)
    
    private String email;

    @OneToOne(mappedBy="employee", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private SalaryEntity salaryInfo;
    
    @OneToOne(mappedBy="employee", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ContractEntity contractInfo;

    @ManyToOne
    private EmployeeEntity manager;

    @OneToMany(mappedBy = "manager")
    private List<EmployeeEntity> dependants;

    @ManyToOne
    private EmployeeEntity matrixManager;

    @OneToMany(mappedBy = "matrixManager")
    private List<EmployeeEntity> matrixDependants;
}
