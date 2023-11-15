package com.api.services.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalaryInfo {
    
    private float pmr;
    private float annualSalary;
    private float ytdCommissions;
    private String compensationGrade;
    private String compensationGradeProfile;
    private String currency;
}
