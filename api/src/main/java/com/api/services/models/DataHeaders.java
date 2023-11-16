package com.api.services.models;

import java.util.Map;

import java.util.HashMap;

public class DataHeaders {
    private static Map<DataFields, String> headers = new HashMap<DataFields, String>(
        Map.ofEntries(
            entry(DataFields.EmployeeId,"Employee ID"),
            entry(DataFields.JobFamily,"Job Family"),
            entry(DataFields.JobProfile,"Job Profile"),
            entry(DataFields.TimeType,"Time Type"),
            entry(DataFields.CostCenterId,"Cost Center - ID"),
            entry(DataFields.CostCenterName,"Cost Center - Name"),
            entry(DataFields.EmployeeType,"Employee Type"),
            entry(DataFields.HireDate,"Hire Date"),
            entry(DataFields.HomeCode,"Home CNUM"),
            entry(DataFields.FirstName,"First Name"),
            entry(DataFields.MidName,"Middle Name"),
            entry(DataFields.LastName,"Last Name"),
            entry(DataFields.Email,"Email - Primary Work"),
            entry(DataFields.ManagerId,"Manager Employee ID"),
            entry(DataFields.AnnualSalary,"Annual Reference Salary"),
            entry(DataFields.PMR,"Compa-Ratio"),
            entry(DataFields.YTD,"YTD Commissions"),
            entry(DataFields.CompensationGrade,"Current Compensation Grade"),
            entry(DataFields.CompensationGradeProfile,"Compensation Grade Profile"),
            entry(DataFields.Currency,"Currency"),
            entry(DataFields.MatrixManagerId,"Matrix Manager Employee ID")
            )
    );

    public static String getField(DataFields field){
        return headers.get(field);
    }

    public static enum DataFields{
        EmployeeId,
        JobFamily,
        JobProfile,
        TimeType,
        CostCenterId,
        CostCenterName,
        EmployeeType,
        HireDate,
        HomeCode,
        FirstName,
        MidName,
        LastName,
        Email,
        ManagerId,
        AnnualSalary,
        PMR,
        YTD,
        CompensationGrade,
        CompensationGradeProfile,
        Currency,
        MatrixManagerId
    }

    private static Map.Entry<DataFields,String> entry(DataFields K, String V){
        return Map.entry(K, V);
    }
}
