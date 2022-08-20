package com.example;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.apache.commons.text.StringSubstitutor;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.example.template.TemplateEngine;

public class TemplateEngineTest {
    @Test
    public void shouldReturnCorrectMessageWithoutBeWrapperInClass() {
        HashMap<String, String> valuesMap = new HashMap<>();
        valuesMap.put("receiverName", "Test");
        String template = "${receiverName} A ${receiverName}";
        StringSubstitutor stringSubstitutor = new StringSubstitutor(valuesMap);
        String expected = "Test A Test";
        String actual = stringSubstitutor.replace(template);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnCorrectMessage() {
        HashMap<String, String> valuesMap = new HashMap<>();
        valuesMap.put("receiverName", "Test");
        String template = "${receiverName} A ${receiverName}";
        TemplateEngine templateEngine = new TemplateEngine(valuesMap, template);
        String expected = "Test A Test";
        String actual = templateEngine.createTemplate();
        assertEquals(expected, actual);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldRaiseExceptionBecauseDontHaveVariable() {
        thrown.expect(IllegalArgumentException.class);
        HashMap<String, String> valuesMap = new HashMap<>();
        valuesMap.put("test1", "Test");
        valuesMap.put("test3", "Test");
        String template = "${test2}";
        TemplateEngine templateEngine = new TemplateEngine(valuesMap, template);
        templateEngine.createTemplate();
    }

    @Test
    public void shouldRaiseExceptionBecauseFirstVariableDontShowInTemplate() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Cannot resolve variable 'test1'");

        HashMap<String, String> valuesMap = new HashMap<>();
        valuesMap.put("test1", "Test");
        valuesMap.put("test2", "Test");
        String template = "${test2}";
        TemplateEngine templateEngine = new TemplateEngine(valuesMap, template);
        templateEngine.createTemplate();
    }

    @Test
    public void shouldRaiseExceptionBecauseVariableDontShowInTemplate() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Cannot resolve variable 'test3'");

        HashMap<String, String> valuesMap = new HashMap<>();
        valuesMap.put("test2", "Test");
        valuesMap.put("test3", "Test");
        String template = "${test2}";
        TemplateEngine templateEngine = new TemplateEngine(valuesMap, template);
        templateEngine.createTemplate();
    }

    @Test
    public void shouldGenerateRightValueKey() {
        HashMap<String, String> valuesMap = new HashMap<>();
        valuesMap.put("test2", "Test");
        valuesMap.put("test3", "Test");
        String template = "${test2}";
        TemplateEngine templateEngine = new TemplateEngine(valuesMap, template);
        String expected = templateEngine.generateValueKey("test2");
        String actual = "${test2}";
        assertEquals(expected, actual);
    }

}

// test1 -> ${test1} Ok
// test1, test3 -> ${test2} Not Ok
// test1,test2, test3 -> ${test2} Not Ok
