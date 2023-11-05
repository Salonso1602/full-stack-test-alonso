package com.api.repository.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xlsxImporter {
    public static Map<Integer, List<String>> getData(String fileLocation) throws FileNotFoundException{
        try{
            FileInputStream file = new FileInputStream(new File(fileLocation));
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            Map<Integer, List<String>> data = new HashMap<>();
            int i = 0;
            for (Row row : sheet) {
                data.put(i, new ArrayList<String>());
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        
                        case NUMERIC: 
                            if (DateUtil.isCellDateFormatted(cell)) {
                                data.get(i).add(cell.getDateCellValue() + "");
                            } else {
                                data.get(i).add(cell.getNumericCellValue() + "");
                            }
                            break;

                        case BOOLEAN: 
                            data.get(i).add(cell.getBooleanCellValue() + ""); 
                            break;

                        case FORMULA: 
                            data.get(i).add(cell.getCellFormula() + "");
                            break;

                        default:
                            data.get(i).add(cell.getRichStringCellValue().getString());
                            break;
                    }
                }
                i++;
            }
            workbook.close();
            return data;
        }
        catch(Exception e){
            throw new FileNotFoundException("No se encontró en archivo en la ruta dada");
        }
    }
}
