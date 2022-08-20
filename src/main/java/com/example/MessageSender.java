package com.example;

import static com.example.template.TemplateFactory.createEmailTemplate;
import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import com.example.template.TemplateEmail;

public class MessageSender {

    public static List<Message> createMessages(LocalDate today, CSVReader csvReader) {
        List<Record> csvRecords = csvReader.getAllRecords();
        List<Record> birthdayPersons = getAllBirthdayPersons(today, csvRecords);

        if (hasNoBirthday(birthdayPersons)) {
            return Collections.emptyList();
        }

        String birthdayPersonNames = concatAllBirthdayPersonsFullName(birthdayPersons);

        return createEmailList(today, csvRecords, birthdayPersonNames);
    }

    private static List<Record> getAllBirthdayPersons(LocalDate today, List<Record> csvRecords) {
        return csvRecords.stream().filter(record -> Util.isBirthday(today, record.birthday()))
                .collect(toList());
    }

    private static boolean hasNoBirthday(List<Record> birthdayPersons) {
        return birthdayPersons.isEmpty();
    }

    private static String concatAllBirthdayPersonsFullName(List<Record> birthdayPersons) {
        return Util.concat(birthdayPersons.stream().map(e -> e.fullname())
                .collect(toList()));
    }

    private static List<Message> createEmailList(LocalDate today, List<Record> csvRecords, String birthdayPersonNames) {
        return csvRecords.stream().map(record -> {
            return createMessage(record, createEmailTemplate(today, birthdayPersonNames, record));
        }).collect(toList());
    }

    private static Message createMessage(Record record, TemplateEmail templateEmail) {
        return new Message(record.email(), templateEmail.getSubject(),
                templateEmail.getBody());
    }

}
