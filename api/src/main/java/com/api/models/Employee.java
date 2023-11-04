package com.api.models;

import java.util.Date;

public class Employee {
    public String EmployeeId;
    public String CountryCode;
    public String FirstName;
    public String MiddleName;
    public String LastName;
    public String Email;
    public String Type;
    public String TimeType;
    public String JobProfileId;
    public Date HireDate;
    public String CostCenterId;

    public Employee(){

    }

    public Employee
    (String employeeId, String countryCode, String firstName, String middleName, String lastName, String email, String type, String timeType, String jobProfileId, Date hireDate, String costCenterId){
        this.EmployeeId = employeeId;
        this.CountryCode = countryCode;
        this.FirstName = firstName;
        this.MiddleName = middleName;
        this.LastName = lastName;
        this.Email = email;
        this.Type = type;
        this.TimeType = timeType;
        this.JobProfileId = jobProfileId;
        this.HireDate = hireDate;
        this.CostCenterId = costCenterId;
    }

    public static Employee FromDTO(){
        return new Employee();
    }
    public static Employee FromEntity(){
        return new Employee();
    }
}
