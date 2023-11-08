package com.api.services.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CostCenter {
    private String costCenterId;
    private String costCenterName;
}
