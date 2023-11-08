package com.api.services.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    
    private String employeeId;
    private String countryCode;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String type;
    private String timeType;
    private JobProfile jobProfile;
    private Date hireDate;
    private CostCenter costCenter;


    public String getFullName(){
        if(this.getMiddleName() != null){
            return this.getFirstName() + " " + this.getMiddleName() + " " + this.getLastName();
        }
        return this.getFirstName() + " " + this.getLastName();
    }
}
