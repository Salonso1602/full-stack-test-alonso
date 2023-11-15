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
            EmployeeEntity manager = repo.findById(DataHeaders.getField(DataHeaders.DataFields.ManagerId)).get();
            EmployeeEntity employee = repo.findById(DataHeaders.getField(DataHeaders.DataFields.EmployeeId)).get();

            employee.setManager(manager);
            repo.save(employee);
        }
        catch(Exception e){
            //continue
            System.out.println("CANT IMPORT MANager");
        }
        try{
            EmployeeEntity matrixManager = repo.findById(DataHeaders.getField(DataHeaders.DataFields.MatrixManagerId)).get();
            EmployeeEntity employee = repo.findById(DataHeaders.getField(DataHeaders.DataFields.EmployeeId)).get();

            employee.setMatrixManager(matrixManager);
            return repo.save(employee);
        }
        catch(Exception e){
            System.out.println("CANT IMPORT MAtrixmaN");
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
