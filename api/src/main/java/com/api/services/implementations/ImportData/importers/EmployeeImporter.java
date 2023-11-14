package com.api.services.implementations.ImportData.importers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.api.repository.entities.entityImplementations.EmployeeEntity;
import com.api.repository.repositories.interfaces.IEmployeeRepository;

@Component
public class EmployeeImporter extends BaseEntityImporter {

    @Autowired
    private IEmployeeRepository repo;

    @Override
    public int importData(Map<String, String> valuesMap) {
        System.out.println("Entered emp importer");
        System.out.println(super.nextImporter);
        System.out.println(this.hasNext());
        buildEmployeeEntity(valuesMap);
        if(hasNext()){
            return super.nextImporter.importData(valuesMap)+1;
        }
        else{
            return 1;
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
}
