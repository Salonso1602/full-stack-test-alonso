package com.api.services.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JobProfile {
    private String jobProfile;
    private String jobFamily;
}
