package com.example.util;

import com.example.CSVReader;
import com.example.Message;

public class CreateUtil {

    public static Message createEmail(String email, String subject, String body) {
        return new Message(email, subject, body);
    }

    public static CSVReader createCsvReader(String fixtureFilename) {
        CsvReaderTestUtil csvReaderTestUtil = new CsvReaderTestUtil();
        return csvReaderTestUtil.create(fixtureFilename);
    }

}
