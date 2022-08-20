package com.example.template;

import java.util.Map;

public class TemplateEmail {

    private String subject;
    private TemplateEngine templateEngine;

    public TemplateEmail(String subject, String template, Map<String, String> valuesMap) {
        this.subject = subject;
        templateEngine = new TemplateEngine(valuesMap, template);

    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return templateEngine.createTemplate();
    }

}
