package com.api.services.implementations.ImportData.importers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.repository.entities.entityImplementations.salaryEntities.CompensationGradeEntity;
import com.api.repository.entities.entityImplementations.salaryEntities.CompensationGradeProfileEntity;
import com.api.repository.entities.entityImplementations.salaryEntities.CurrencyEntity;
import com.api.repository.entities.entityImplementations.salaryEntities.SalaryEntity;
import com.api.repository.repositories.interfaces.salaryRepos.ICompensationGradeProfileRepository;
import com.api.repository.repositories.interfaces.salaryRepos.ICompensationGradeRepository;
import com.api.repository.repositories.interfaces.salaryRepos.ICurrencyRepository;
import com.api.repository.repositories.interfaces.salaryRepos.ISalaryRepository;

@Component
public class SalaryImporter extends BaseEntityImporter {

    @Autowired
    private ISalaryRepository repoSal;
    @Autowired
    private ICompensationGradeRepository repoCG;
    @Autowired
    private ICompensationGradeProfileRepository repoCGP;
    @Autowired 
    private ICurrencyRepository repoCur;

    @Override
    public int importData(Map<String, String> valuesMap) {
        if(canImport(valuesMap)){
            buildSalaryEntity(valuesMap);
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
    
    private SalaryEntity buildSalaryEntity (Map<String, String> valuesMap){
        SalaryEntity sal = SalaryEntity.builder()
        .compensationGrade(buildCompensationGradeProfile(valuesMap))
        .annualSalary(Float.parseFloat(valuesMap.get("Annual Reference Salary")))
        .currency(buildCurrencyEntity(valuesMap))
        .employeeId(valuesMap.get("Employee ID"))
        .pmr(Float.parseFloat(valuesMap.get("Compa-Ratio"))*100)
        .ytdCommissions(Float.parseFloat(valuesMap.get("YTD Commissions")))
        .build();
        System.out.println(sal.toString());
        return repoSal.save(sal);
    }

    private CompensationGradeEntity buildCompensationGrade(Map<String, String> valuesMap){
        return repoCG.save(new CompensationGradeEntity(valuesMap.get("Compensation Grade")));
    }
    private CompensationGradeProfileEntity buildCompensationGradeProfile(Map<String, String> valuesMap){
        return repoCGP.save (new CompensationGradeProfileEntity(valuesMap.get("Compensation Grade Profile"), buildCompensationGrade(valuesMap)));
    }
    private CurrencyEntity buildCurrencyEntity (Map<String, String> valuesMap){
        return repoCur.save(new CurrencyEntity(valuesMap.get("Currency"),valuesMap.get("Currency Name"),valuesMap.get("Currency Symbol")));
    }

    @Override
    public boolean canImport(Map<String, String> valuesMap) {
        return (
            valuesMap.containsKey("Annual Reference Salary") &&
            valuesMap.containsKey("Employee ID") &&
            valuesMap.containsKey("Compa-Ratio") &&
            valuesMap.containsKey("YTD Commissions") &&
            valuesMap.containsKey("Compensation Grade") &&
            valuesMap.containsKey("Compensation Grade Profile") &&
            valuesMap.containsKey("Currency")
        );
    }
}
