package com.api.services.helpers.mappers;

import com.api.repository.entities.entityImplementations.contractEntities.CostCenterEntity;
import com.api.services.models.CostCenter;

public class CostCenterMapper extends BaseMapper<CostCenter, CostCenterEntity> {

    @Override
    public CostCenter mapObject(CostCenterEntity ent) {
        return CostCenter.builder()
        .costCenterId(ent.getId())
        .costCenterName(ent.getCenterName())
        .build();
    }

    @Override
    public CostCenterEntity mapReverse(CostCenter mod) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mapReverse'");
    } 
}
