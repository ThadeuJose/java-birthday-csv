package com.example;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

public class CSVOneRegisterTest {

    @Test
    public void shouldReturnCorrectRegister() {
        ClassLoader classLoader = getClass().getClassLoader();
        String filePath = classLoader.getResource("dataOneRegister.csv").getPath();
        CSVReader csvReader = new CSVReader(filePath);
        List<Record> records = csvReader.getAllRecords();

        Record expected = new Record("Doe", "John", LocalDate.of(1982, 10, 8), "john.doe@foobar.com");
        Record record = records.get(0);
        assertEquals(expected, record);
    }

}
