package com.example.template.templatemaker;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.example.Util;
import com.example.template.TemplateEmail;
import com.example.Record;

public class TemplateMakerReminder implements TemplateMaker {

    private Record record;
    private String birthdayPersonNames;

    public TemplateMakerReminder(Record record, String birthdayPersonNames) {
        this.record = record;
        this.birthdayPersonNames = birthdayPersonNames;
    }

    @Override
    public boolean apply(LocalDate today) {
        return !Util.isBirthday(today, record.birthday());
    }

    @Override
    public TemplateEmail createTemplate() {

        String subject = "Birthday Reminder";
        String template = "Dear ${receiverName},\nToday is ${birthdayPersonNames}'s birthday.\nDon't forget to send them a message !";

        Map<String, String> valuesMap = new HashMap<>();
        valuesMap.put("receiverName", record.firstName());
        valuesMap.put("birthdayPersonNames", birthdayPersonNames);

        return new TemplateEmail(subject, template, valuesMap);
    }

}
