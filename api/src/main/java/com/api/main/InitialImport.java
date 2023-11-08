package com.api.main;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.api.repository.helpers.xlsxImporter;

@Component
public class InitialImport implements ApplicationListener<ApplicationReadyEvent> {

    @Value("${firstTime}")
    private boolean firstTime;

    @Value("${dataLocation}")
    private List<String> dataLocs;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        if(firstTime){
            for(String loc : dataLocs){
                try{
                    Collection<Map<String,String>> rows = xlsxImporter.getData(loc).values();
                    for(Map<String,String> row : rows){
                        for(String col : row.keySet()){
                            switch (row.get(col)) {
                                case "Worker":
                                    
                                    break;
                            
                                default:
                                    //skip
                                    break;
                            }
                        }
                    }

                }
                catch(FileNotFoundException ex){
                    System.out.print(loc + " FILE NOT FOUND");
                    continue;
                }
                
            }
        }
    }
    
}
