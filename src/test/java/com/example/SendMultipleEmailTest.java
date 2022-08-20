package com.example;

import static com.example.util.CreateUtil.createCsvReader;
import static com.example.util.CreateUtil.createEmail;
import static com.example.util.CustomAssertions.assertAllPeoplesReceiveMessage;
import static com.example.util.CustomAssertions.assertMessageWasCreated;

import java.time.LocalDate;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class SendMultipleEmailTest {

    private static final String FIXTURE_FILENAME = "dataFourRegister.csv";

    private static CSVReader csvReader;
    private static LocalDate maryBirthday;

    @BeforeClass
    public static void setUp() {
        csvReader = createCsvReader(FIXTURE_FILENAME);
        maryBirthday = createMaryBirthday();
    }

    @Test
    public void shouldCreateCorrectEmailForMary() {
        List<Message> messages = MessageSender.createMessages(maryBirthday, csvReader);
        String email = "mary.ann@foobar.com";
        String subject = "Happy birthday!";
        String body = "Happy birthday, dear Mary!";
        Message message = createEmail(email, subject, body);
        int quantityOfReceiver = 4;
        assertAllPeoplesReceiveMessage(messages, quantityOfReceiver);
        assertMessageWasCreated(messages, message);
    }

    @Test
    public void shouldCreateCorrectEmailForViolet() {
        List<Message> messages = MessageSender.createMessages(maryBirthday, csvReader);
        String email = "violet.black@foobar.com";
        String subject = "Happy birthday!";
        String body = "Happy birthday, dear Violet!";
        Message message = createEmail(email, subject, body);
        int quantityOfReceiver = 4;
        assertAllPeoplesReceiveMessage(messages, quantityOfReceiver);
        assertMessageWasCreated(messages, message);
    }

    @Test
    public void shouldCreateCorrectReminderEmailForOtherPeople() {
        List<Message> messages = MessageSender.createMessages(maryBirthday, csvReader);
        String email = "john.doe@foobar.com";
        String subject = "Birthday Reminder";
        String body = "Dear John,\nToday is Mary Ann and Violet Black's birthday.\nDon't forget to send them a message !";
        Message message = createEmail(email, subject, body);
        int quantityOfReceiver = 4;
        assertAllPeoplesReceiveMessage(messages, quantityOfReceiver);
        assertMessageWasCreated(messages, message);
    }

    private static LocalDate createMaryBirthday() {
        return LocalDate.of(2022, 9, 11);
    }
}