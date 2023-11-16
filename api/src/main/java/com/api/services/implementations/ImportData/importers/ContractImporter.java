package com.api.services.implementations.ImportData.importers;

import java.util.Date;
import java.util.Map;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

import com.api.repository.entities.entityImplementations.contractEntities.ContractEntity;
import com.api.repository.entities.entityImplementations.contractEntities.CostCenterEntity;
import com.api.repository.entities.entityImplementations.contractEntities.EmployeeTypeEntity;
import com.api.repository.entities.entityImplementations.contractEntities.JobFamilyEntity;
import com.api.repository.entities.entityImplementations.contractEntities.JobProfileEntity;
import com.api.repository.entities.entityImplementations.contractEntities.TimeTypeEntity;
import com.api.repository.repositories.interfaces.IEmployeeRepository;
import com.api.repository.repositories.interfaces.contractRepos.IContractRepository;
import com.api.repository.repositories.interfaces.contractRepos.ICostCenterRepository;
import com.api.repository.repositories.interfaces.contractRepos.IEmployeeTypeRepository;
import com.api.repository.repositories.interfaces.contractRepos.IJobFamilyRepository;
import com.api.repository.repositories.interfaces.contractRepos.IJobProfileRepository;
import com.api.repository.repositories.interfaces.contractRepos.ITimeTypeRepository;
import com.api.services.models.DataHeaders;

@Component
public class ContractImporter extends BaseEntityImporter {

    @Autowired
    private IContractRepository repoContract;
    @Autowired
    private IJobFamilyRepository repoJF;
    @Autowired
    private IJobProfileRepository repoJP;
    @Autowired
    private ITimeTypeRepository repoTime;
    @Autowired
    private ICostCenterRepository repoCost;
    @Autowired
    private IEmployeeTypeRepository repoEmpType;
    @Autowired
    private IEmployeeRepository repoEmps;

    @Override
    public int importData(Map<String, String> valuesMap) {
        if (canImport(valuesMap)) {
            buildContract(valuesMap);
            if (hasNext()) {
                return super.nextImporter.importData(valuesMap) + 1;
            } else {
                return 1;
            }
        }
        else{
            System.out.println(valuesMap);
        }
        if (hasNext()) {
            return super.nextImporter.importData(valuesMap);
        } else {
            return 0;
        }
    }

    private JobFamilyEntity buildJobFamily(Map<String, String> valuesMap) {
        return repoJF.findById(valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.JobFamily)))
            .orElse(repoJF.save(new JobFamilyEntity(valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.JobFamily)))));
    }

    private JobProfileEntity buildJobProfile(Map<String, String> valuesMap) {
        return repoJP.findById(valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.JobProfile)))
            .orElse(repoJP.save(new JobProfileEntity(valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.JobProfile)), buildJobFamily(valuesMap))));
    }

    private TimeTypeEntity buildTimeType(Map<String, String> valuesMap) {
        return repoTime.findById(valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.TimeType)))
            .orElse(repoTime.save(new TimeTypeEntity(valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.TimeType)))));
    }

    private CostCenterEntity buildCenter(Map<String, String> valuesMap) {
        return repoCost.findById(valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.CostCenterId)))
            .orElse(repoCost.save(new CostCenterEntity(valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.CostCenterId)), valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.CostCenterName)))));
    }

    private EmployeeTypeEntity buildEmployeeType(Map<String, String> valuesMap) {
        return repoEmpType.findById(valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.EmployeeType)))
            .orElse(repoEmpType.save(new EmployeeTypeEntity(valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.EmployeeType)))));
    }

    private ContractEntity buildContract(Map<String, String> valuesMap) {

        Date hireDate = null;
        try {
            hireDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH)
                    .parse(valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.HireDate)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ContractEntity cont = repoContract.save(ContractEntity.builder()
                .employee(repoEmps.findById(valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.EmployeeId))).get())
                .timeType(buildTimeType(valuesMap))
                .costCenter(buildCenter(valuesMap))
                .type(buildEmployeeType(valuesMap))
                .timeType(buildTimeType(valuesMap))
                .jobProfile(buildJobProfile(valuesMap))
                .hireDate(hireDate)
                .build());
        return cont;
    }

    @Override
    public boolean canImport(Map<String, String> valuesMap) {
        return (valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.JobFamily)) != null &&
                valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.JobProfile)) != null &&
                valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.TimeType)) != null &&
                valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.CostCenterId)) != null &&
                valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.CostCenterName)) != null &&
                valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.EmployeeType)) != null &&
                valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.HireDate)) != null &&
                valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.EmployeeId)) != null);
    }

}
