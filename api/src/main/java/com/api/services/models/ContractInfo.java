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
public class ContractInfo {
    
    private JobProfile jobProfile;
    private Date hireDate;
    private CostCenter costCenter;
    private String type;
    private String timeType;
}
