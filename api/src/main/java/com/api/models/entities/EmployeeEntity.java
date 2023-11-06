package com.api.models.entities;

import org.apache.poi.hpsf.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class EmployeeEntity {

    @Id
    private String employeeId;

    private String countryCode;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String type;
    private String timeType;
    private String jobProfileId;
    private Date hireDate;
    private String costCenterId;


}
