package com.api.services.implementations.ImportData.importers;

import java.util.Map;


public abstract class BaseEntityImporter {
    protected BaseEntityImporter nextImporter;

    public boolean hasNext(){
        return this.nextImporter != null;
    }

    public BaseEntityImporter setNext(BaseEntityImporter next){
        this.nextImporter = next;
        return this.nextImporter;
    }

    public abstract int importData(Map<String, String> valuesMap);
}
