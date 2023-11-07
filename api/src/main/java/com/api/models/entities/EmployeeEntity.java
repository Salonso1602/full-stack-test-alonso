package com.api.models.entities;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "employee")
public class EmployeeEntity {

    @Id
    @Column(
        name = "employee_id",
        updatable = false
    )
    private String employeeId;

    @Column(
        name = "country_code"
    )
    private String countryCode;

    @Column(
        name = "first_name"
    )
    private String firstName;

    @Column(
        name = "middle_name"
    )
    private String middleName;

    @Column(
        name = "last_name"
    )
    private String lastName;

    @Column(
        name = "email",
        unique = true
    )
    private String email;

    @Column(
        name = "type"
    )
    private String type;

    @Column(
        name = "time_type"
    )
    private String timeType;

    @Column(
        name = "job_profile_id"
    )
    private String jobProfileId;

    @Column(
        name = "hire_date",
        updatable = false
    )
    private Date hireDate;

    @Column(
        name = "cost_center_id",
        updatable = false
    )
    private String costCenterId;

}
