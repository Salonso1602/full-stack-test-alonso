package com.api.services.implementations.ImportData.importers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.repository.entities.entityImplementations.EmployeeEntity;
import com.api.repository.repositories.interfaces.IEmployeeRepository;

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
                .employeeId(valuesMap.get("Employee ID"))
                .countryCode(valuesMap.get("Home CNUM"))
                .firstName(valuesMap.get("First Name"))
                .middleName(valuesMap.get("Middle Name"))
                .lastName(valuesMap.get("Last Name"))
                .email(valuesMap.get("Email - Primary Work"))
                .manager(valuesMap.get("Manager Employee ID"))
                .matrixManager(valuesMap.get("Matrix Manager Employee ID"))
                .build();

        return repo.save(emp);
    }

    @Override
    public boolean canImport(Map<String, String> valuesMap) {
        return (
            valuesMap.containsKey("Employee ID") &&
            valuesMap.containsKey("Home CNUM") &&
            valuesMap.containsKey("First Name") &&
            valuesMap.containsKey("Middle Name") &&
            valuesMap.containsKey("Last Name") &&
            valuesMap.containsKey("Email - Primary Work") &&
            valuesMap.containsKey("Manager Employee ID") &&
            valuesMap.containsKey("Matrix Manager Employee ID")
        );
    }
}
