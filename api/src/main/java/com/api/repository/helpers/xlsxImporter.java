package com.api.repository.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xlsxImporter {
    public static Map<Integer, Map<String,String>> getData(String fileLocation) throws FileNotFoundException{
        try{
            FileInputStream file = new FileInputStream(new File(fileLocation));
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            //Creamos lista con claves para mapa de cada empleado
            ArrayList<String> colNames = new ArrayList<String>();
            for(Cell cell : sheet.getRow(1)){
                colNames.add(cell.getRichStringCellValue().getString());
            }

            int i = 0;
            Map<Integer, Map<String,String>> data = new HashMap<>();

            //Se saltean primeras 2 filas ya que son headers
            Iterator<Row> rowIterator = sheet.rowIterator();
            rowIterator.next();
            rowIterator.next();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                data.put(i, new HashMap<String,String>());
                int j = 0;
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case NUMERIC: 
                            if (DateUtil.isCellDateFormatted(cell)) {
                                data.get(i).put(colNames.get(j), cell.getDateCellValue() + "");
                            } else {
                                data.get(i).put(colNames.get(j), cell.getNumericCellValue() + "");
                            }
                            break;

                        case BOOLEAN: 
                            data.get(i).put(colNames.get(j), cell.getBooleanCellValue() + ""); 
                            break;

                        case FORMULA: 
                            data.get(i).put(colNames.get(j), cell.getCellFormula() + "");
                            break;

                        default:
                            data.get(i).put(colNames.get(j), cell.getRichStringCellValue().getString());
                            break;
                    }
                    j++;
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
