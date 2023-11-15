package com.api.services.implementations.ImportData.importers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.repository.entities.entityImplementations.EmployeeEntity;
import com.api.repository.repositories.interfaces.IEmployeeRepository;
import com.api.services.models.DataHeaders;

@Component
public class EmployeeImporter extends BaseEntityImporter {

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
        if (hasNext()) {
                return super.nextImporter.importData(valuesMap);
            } else {
                return 0;
            }
    }

    private EmployeeEntity buildEmployeeEntity(Map<String, String> valuesMap) {
        
        EmployeeEntity emp = EmployeeEntity.builder()
                .employeeId(valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.EmployeeId)))
                .countryCode(valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.HomeCode)))
                .firstName(valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.FirstName)))
                .middleName(valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.MidName)))
                .lastName(valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.LastName)))
                .email(valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.Email)))
                .build();
        return repo.save(emp);
    }

    @Override
    public boolean canImport(Map<String, String> valuesMap) {
        return (
            valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.EmployeeId)) != null &&
            valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.HomeCode)) != null &&
            valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.FirstName)) != null &&
            valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.LastName)) != null &&
            valuesMap.get(DataHeaders.getField(DataHeaders.DataFields.Email)) != null 
        );
    }
}
