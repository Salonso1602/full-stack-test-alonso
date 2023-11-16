package com.api.services.helpers.mappers;

import com.api.repository.entities.entityImplementations.contractEntities.ContractEntity;
import com.api.repository.entities.entityImplementations.contractEntities.CostCenterEntity;
import com.api.repository.entities.entityImplementations.contractEntities.JobProfileEntity;
import com.api.services.helpers.IEntityMapper;
import com.api.services.models.ContractInfo;
import com.api.services.models.CostCenter;
import com.api.services.models.JobProfile;

public class ContractMapper extends BaseMapper<ContractInfo, ContractEntity> {
    
    private IEntityMapper<JobProfile,JobProfileEntity> jobProfMapper = new JobProfileMapper();
    private IEntityMapper<CostCenter,CostCenterEntity> costCenterMapper = new CostCenterMapper();

    @Override
    public ContractInfo mapObject(ContractEntity object) {
        if(object == null){
            return null;
        }

        return ContractInfo.builder()
        .jobProfile(jobProfMapper.mapObject(object.getJobProfile()))
        .costCenter(costCenterMapper.mapObject(object.getCostCenter()))
        .timeType(object.getTimeType().getTimeType())
        .type(object.getType().getEmployeeType())
        .hireDate(object.getHireDate())
        .build();
    }
    @Override
    public ContractEntity mapReverse(ContractInfo object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mapReverse'");
    }

    
    
}
