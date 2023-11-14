package com.api.services.implementations.ImportData.importers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImporterChain {
    @Autowired
    private ContractImporter contrs;
    @Autowired
    private EmployeeImporter emps;
    @Autowired
    private SalaryImporter sals;


    public BaseEntityImporter getChain(){
        emps.setNext(sals).setNext(contrs);
        return emps;
    }
}
