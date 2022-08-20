package com.example;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSVReader {

    private enum HEADERS {
        last_name, first_name, date_of_birth, email
    }

    List<Record> record;

    public CSVReader(String filename) {
        try (CSVParser parser = new CSVParser(new FileReader(filename), createCSVFormat())) {
            record = parser.stream()
                    .map(this::mapCSVRecordToRecord)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Record mapCSVRecordToRecord(CSVRecord record) {
        return new Record(record.get(HEADERS.last_name), record.get(HEADERS.first_name),
                createLocalDate(record.get(HEADERS.date_of_birth)),
                record.get(HEADERS.email));
    }

    private LocalDate createLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return LocalDate.parse(date, formatter);
    }

    private CSVFormat createCSVFormat() {
        return CSVFormat.EXCEL.builder()
                .setDelimiter(", ")
                .setHeader(HEADERS.class)
                .setSkipHeaderRecord(true)
                .build();
    }

    public List<Record> getAllRecords() {
        return record;
    }

}
