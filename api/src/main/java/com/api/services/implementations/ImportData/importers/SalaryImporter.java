package com.api.services.implementations.ImportData.importers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.repository.entities.entityImplementations.salaryEntities.CompensationGradeEntity;
import com.api.repository.entities.entityImplementations.salaryEntities.CompensationGradeProfileEntity;
import com.api.repository.entities.entityImplementations.salaryEntities.CurrencyEntity;
import com.api.repository.entities.entityImplementations.salaryEntities.SalaryEntity;
import com.api.repository.repositories.interfaces.IEmployeeRepository;
import com.api.repository.repositories.interfaces.salaryRepos.ICompensationGradeProfileRepository;
import com.api.repository.repositories.interfaces.salaryRepos.ICompensationGradeRepository;
import com.api.repository.repositories.interfaces.salaryRepos.ICurrencyRepository;
import com.api.repository.repositories.interfaces.salaryRepos.ISalaryRepository;
import com.api.services.models.DataHeaders;

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
    @Autowired
    private IEmployeeRepository repoEmps;

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
        float pmr =  0;
        try{
            pmr = Float.parseFloat(valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.PMR)))*100;
        } catch (Exception e){
            //default to val 0
        }
        float ytd =  0;
        try{
            ytd = Float.parseFloat(valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.YTD)));
        } catch (Exception e){
            //default to val 0
        }
        float as =  0;
        try{
            as = Float.parseFloat(valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.AnnualSalary)));
        } catch (Exception e){
            //default to val 0
        }

        SalaryEntity sal = SalaryEntity.builder()
        .compensationGrade(buildCompensationGradeProfile(valuesMap))
        .annualSalary(as)
        .currency(buildCurrencyEntity(valuesMap))
        .employee(repoEmps.findById(valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.EmployeeId))).get())
        .pmr(pmr)
        .ytdCommissions(ytd)
        .build();

        return repoSal.save(sal);
    }

    private CompensationGradeEntity buildCompensationGrade(Map<String, String> valuesMap){
        return repoCG.save(new CompensationGradeEntity(valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.CompensationGrade))));
    }
    private CompensationGradeProfileEntity buildCompensationGradeProfile(Map<String, String> valuesMap){
        return repoCGP.save (new CompensationGradeProfileEntity(valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.CompensationGradeProfile)), buildCompensationGrade(valuesMap)));
    }
    private CurrencyEntity buildCurrencyEntity (Map<String, String> valuesMap){
        return repoCur.save(new CurrencyEntity(valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.Currency))));
    }

    @Override
    public boolean canImport(Map<String, String> valuesMap) {
        return (
            valuesMap.containsKey(DataHeaders.getField(DataHeaders.DataFields.AnnualSalary)) &&
            valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.EmployeeId)) != null &&
            valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.PMR)) != null &&
            valuesMap.containsKey(DataHeaders.getField(DataHeaders.DataFields.YTD)) &&
            valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.CompensationGrade)) != null &&
            valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.CompensationGradeProfile)) != null &&
            valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.Currency)) != null
        );
    }
}
