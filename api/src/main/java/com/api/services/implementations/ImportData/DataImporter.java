package com.api.services.implementations.ImportData;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.api.repository.helpers.xlsxImporter;
import com.api.services.implementations.ImportData.importers.ImporterChain;
import com.api.services.interfaces.IDataImporter;

@Service
public class DataImporter implements IDataImporter {

    @Value("${firstTime}")
    private boolean firstTime = true;

    @Value("${dataLocation}")
    private String loc;

    @Autowired
    private ImporterChain importers;

    public int startupScan() {
        return importData("data/Employee_Max_Detail_Report.xlsx")
                + importData("data/Employee_Compensation_Details_-_Manager_version.xlsx")
                ;
    }

    public int importData(String loc) {
        int count = 0;
        try {
            Collection<Map<String, String>> rows = xlsxImporter.getData(loc)
                    .values();
            for (Map<String, String> row : rows) {
                try {
                    count += importers.getChain().importData(row);
                } catch (Exception e) {
                    System.out.println("ImportDataExcp " + e.getMessage() + e.getClass());
                    System.out.println(e.getStackTrace()[0].getFileName() + e.getStackTrace()[0].getLineNumber() + e.getStackTrace()[0].toString());
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(loc + " FILE NOT FOUND");
        }
        return count;
    }

}
