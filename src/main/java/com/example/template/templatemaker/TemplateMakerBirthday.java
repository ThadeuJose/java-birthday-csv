package com.example.template.templatemaker;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.example.Util;
import com.example.template.TemplateEmail;
import com.example.Record;

public class TemplateMakerBirthday implements TemplateMaker {

    private Record record;

    public TemplateMakerBirthday(Record record) {
        this.record = record;
    }

    @Override
    public boolean apply(LocalDate today) {
        return Util.isBirthday(today, record.birthday());
    }

    @Override
    public TemplateEmail createTemplate() {
        String subject = "Happy birthday!";
        String template = "Happy birthday, dear ${receiverName}!";
        Map<String, String> valuesMap = new HashMap<>();
        valuesMap.put("receiverName", record.firstName());
        return new TemplateEmail(subject, template, valuesMap);
    }

}
