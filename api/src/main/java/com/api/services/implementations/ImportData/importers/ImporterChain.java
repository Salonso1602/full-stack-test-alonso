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
    @Autowired
    private ManagerImporter mans;


    public BaseEntityImporter getChain(){
        emps.setNext(mans).setNext(sals).setNext(contrs);
        return emps;
    }
}
