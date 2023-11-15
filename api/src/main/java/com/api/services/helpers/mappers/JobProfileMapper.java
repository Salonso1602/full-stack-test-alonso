package com.api.services.helpers.mappers;

import com.api.repository.entities.entityImplementations.contractEntities.JobProfileEntity;
import com.api.services.models.JobProfile;

public class JobProfileMapper extends BaseMapper<JobProfile, JobProfileEntity> {

    @Override
    public JobProfile mapObject(JobProfileEntity ent) {
        return JobProfile.builder()
        .jobProfile(ent.getProfile())
        .jobFamily(ent.getFamily().getFamilyName())
        .build();
    }

    @Override
    public JobProfileEntity mapReverse(JobProfile mod) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mapReverse'");
    }
}
