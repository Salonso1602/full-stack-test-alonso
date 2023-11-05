package com.api.models;

import java.util.Date;

import io.micrometer.common.lang.NonNull;
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
    private String jobProfileId;
    private Date hireDate;
    private String costCenterId;


    public static Employee FromDTO(){
        return new Employee();
    }
    public static Employee FromEntity(){
        return new Employee();
    }
}
