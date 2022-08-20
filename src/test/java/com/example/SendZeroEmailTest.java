package com.example;

import static com.example.util.CreateUtil.createCsvReader;
import static com.example.util.CustomAssertions.assertAllPeoplesReceiveMessage;

import java.time.LocalDate;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class SendZeroEmailTest {

    private static final String FIXTURE_FILENAME = "dataZeroRegister.csv";

    private static CSVReader csvReader;
    private static LocalDate noBirthday;

    @BeforeClass
    public static void setUp() {
        csvReader = createCsvReader(FIXTURE_FILENAME);
        noBirthday = createNoBirthday();
    }

    @Test
    public void shouldCreateZeroEmails() {
        List<Message> messages = MessageSender.createMessages(noBirthday, csvReader);
        int quantityOfReceiver = 0;
        assertAllPeoplesReceiveMessage(messages, quantityOfReceiver);

    }

    private static LocalDate createNoBirthday() {
        return LocalDate.of(2022, 9, 11);
    }
}