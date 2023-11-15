package com.api.helpers.mappers;

import com.api.repository.entities.entityImplementations.salaryEntities.SalaryEntity;
import com.api.services.models.SalaryInfo;

public class SalaryMapper extends BaseMapper<SalaryInfo, SalaryEntity> {

    @Override
    public SalaryInfo mapObject(SalaryEntity object) {
        if(object == null){
            return null;
        }

        return SalaryInfo.builder()
        .annualSalary(object.getAnnualSalary())
        .pmr(object.getPmr())
        .ytdCommissions(object.getYtdCommissions())
        .compensationGrade(object.getCompensationGrade().getGrade().getGrade())
        .compensationGradeProfile(object.getCompensationGrade().getProfile())
        .currency(object.getCurrency().getCode())
        .build();
    }

    @Override
    public SalaryEntity mapReverse(SalaryInfo object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mapReverse'");
    }
    
}
