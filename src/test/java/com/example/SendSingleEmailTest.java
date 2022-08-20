package com.example;

import static com.example.util.CreateUtil.createCsvReader;
import static com.example.util.CreateUtil.createEmail;
import static com.example.util.CustomAssertions.assertMessageWasCreated;

import java.time.LocalDate;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class SendSingleEmailTest {

    private static final String FIXTURE_FILENAME = "dataOneRegister.csv";

    private static CSVReader csvReader;
    private static LocalDate johnBirthday;

    @BeforeClass
    public static void setUp() {
        csvReader = createCsvReader(FIXTURE_FILENAME);
        johnBirthday = createJohnBirthday();
    }

    @Test
    public void shouldCreateCorrectEmailForJohn() {
        List<Message> messagesCreated = MessageSender.createMessages(johnBirthday, csvReader);
        String email = "john.doe@foobar.com";
        String subject = "Happy birthday!";
        String body = "Happy birthday, dear John!";
        Message message = createEmail(email, subject, body);
        assertMessageWasCreated(messagesCreated, message);
    }

    public static LocalDate createJohnBirthday() {
        return LocalDate.of(2022, 10, 8);
    }
}
