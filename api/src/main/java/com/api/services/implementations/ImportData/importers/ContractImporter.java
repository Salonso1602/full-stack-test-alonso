package com.api.services.implementations.ImportData.importers;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

import com.api.repository.entities.entityImplementations.EmployeeEntity;
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

@Component
public class ContractImporter extends BaseEntityImporter{

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
        if(canImport(valuesMap)){
            buildContract(valuesMap);
            if(hasNext()){
                return super.nextImporter.importData(valuesMap)+1;
            }
            else{
                return 1;
            }
        }
        if(hasNext()){
                return super.nextImporter.importData(valuesMap);
            }
            else{
                return 0;
            }
    }

    private JobFamilyEntity buildJobFamily(Map<String, String> valuesMap){
        return repoJF.save(new JobFamilyEntity(valuesMap.get("Job Family")));
    }
    private JobProfileEntity buildJobProfile(Map<String, String> valuesMap){
        return repoJP.save(new JobProfileEntity(valuesMap.get("Job Profile"), buildJobFamily(valuesMap)));
    }
    private TimeTypeEntity buildTimeType(Map<String, String> valuesMap){
        return repoTime.save(new TimeTypeEntity(valuesMap.get("Time Type")));
    }
    private CostCenterEntity buildCenter(Map<String, String> valuesMap){
        return repoCost.save(new CostCenterEntity(valuesMap.get("Cost Center - ID"), valuesMap.get("Cost Center - Name")));
    }
    private EmployeeTypeEntity buildEmployeeType(Map<String, String> valuesMap){
        return repoEmpType.save(new EmployeeTypeEntity(valuesMap.get("Employee Type")));
    }
    private ContractEntity buildContract(Map<String, String> valuesMap){

        Date hireDate = new Date();
        try{
            hireDate = new SimpleDateFormat("dd/MM/yyyy").parse(valuesMap.get("Hire Date"));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        ContractEntity cont = repoContract.save( ContractEntity.builder()
        .employeeId(valuesMap.get("Employee ID"))
        .employee(repoEmps.findById(valuesMap.get("Employee ID")).get())
        .timeType(buildTimeType(valuesMap))
        .costCenter(buildCenter(valuesMap))
        .type(buildEmployeeType(valuesMap))
        .timeType(buildTimeType(valuesMap))
        .jobProfile(buildJobProfile(valuesMap))
        .hireDate(hireDate)
        .build());

        System.out.println(cont.toString());

        return cont;
        }

    @Override
    public boolean canImport(Map<String, String> valuesMap) {
        return (
            valuesMap.get("Job Family") != null &&
            valuesMap.get("Job Profile") != null &&
            valuesMap.get("Time Type") != null &&
            valuesMap.get("Cost Center - ID") != null &&
            valuesMap.get("Cost Center - Name") != null &&
            valuesMap.get("Employee Type") != null &&
            valuesMap.get("Hire Date") != null &&
            valuesMap.get("Employee ID") != null
        );
    }
    
}
