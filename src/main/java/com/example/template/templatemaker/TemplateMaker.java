package com.example.template.templatemaker;

import java.time.LocalDate;

import com.example.template.TemplateEmail;

public interface TemplateMaker {

    public boolean apply(LocalDate today);

    public TemplateEmail createTemplate();

}
