package com.api.services.implementations.ImportData.importers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.repository.entities.entityImplementations.EmployeeEntity;
import com.api.repository.repositories.interfaces.IEmployeeRepository;
import com.api.services.models.DataHeaders;

@Component
public class ManagerImporter extends BaseEntityImporter {

    @Autowired
    private IEmployeeRepository repo;

    @Override
    public int importData(Map<String, String> valuesMap) {
        if(canImport(valuesMap)){
            buildEmployeeEntity(valuesMap);
            if (hasNext()) {
                return super.nextImporter.importData(valuesMap) + 1;
            } else {
                return 1;
            }
        }
        else{
            System.out.println("CANT IMPORT MAN");
        }
        if (hasNext()) {
                return super.nextImporter.importData(valuesMap);
            } else {
                return 0;
            }
    }

    private EmployeeEntity buildEmployeeEntity(Map<String, String> valuesMap) {
        
        try{
            EmployeeEntity employee = repo.findById(valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.EmployeeId))).get();
            EmployeeEntity manager = repo.findById(valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.ManagerId))).get();

            employee.setManager(manager);
            repo.save(employee);
        }
        catch(Exception e){
            //continue
        }
        try{
            EmployeeEntity employee = repo.findById(valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.EmployeeId))).get();
            EmployeeEntity matrixManager = repo.findById(valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.MatrixManagerId))).get();

            employee.setMatrixManager(matrixManager);
            return repo.save(employee);
        }
        catch(Exception e){
            return null;
        }
    }

    @Override
    public boolean canImport(Map<String, String> valuesMap) {
        return (
            valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.EmployeeId)) != null &&
            valuesMap.containsKey(DataHeaders.getField(DataHeaders.DataFields.ManagerId)) &&
            valuesMap.containsKey(DataHeaders.getField(DataHeaders.DataFields.MatrixManagerId)) 
        );
    }
}
