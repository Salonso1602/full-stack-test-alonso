package com.api.services.interfaces;

public interface IDataImporter {
    int startupScan();
    int importData(String path);
}
