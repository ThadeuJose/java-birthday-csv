package com.example.util;

import com.example.CSVReader;

public class CsvReaderTestUtil {

    public CsvReaderTestUtil() {
    }

    public CSVReader create(String fixtureFilename) {
        String filePath = getPath(fixtureFilename);
        CSVReader csvReader = new CSVReader(filePath);
        return csvReader;
    }

    public String getPath(String filename) {
        ClassLoader classLoader = getClass().getClassLoader();
        return classLoader.getResource(filename).getPath();
    }

}
