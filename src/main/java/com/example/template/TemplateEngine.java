package com.example.template;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.text.StringSubstitutor;

public class TemplateEngine {
    private StringSubstitutor stringSubstitutor;
    private String template;
    private final boolean FAIL_ON_UNDEFINED_VARIABLE = true;
    private HashMap<String, String> valuesMap;

    public TemplateEngine(Map<String, String> map, String template) {
        this.template = template;
        valuesMap = new HashMap<>(map);
        stringSubstitutor = new StringSubstitutor(valuesMap);
        stringSubstitutor.setEnableUndefinedVariableException(FAIL_ON_UNDEFINED_VARIABLE);
    }

    public String createTemplate() {
        valuesMap.forEach((k, v) -> validate(k));
        return stringSubstitutor.replace(template);
    }

    private void validate(String key) {
        if (!hasValue(key)) {
            throw new IllegalArgumentException("Cannot resolve variable '" + key + "'");
        }
    }

    private boolean hasValue(String key) {
        return template.contains(generateValueKey(key));
    }

    public String generateValueKey(String key) {
        StringBuilder stringBuilder = new StringBuilder();
        char escapeChar = stringSubstitutor.getEscapeChar();
        String prefixChar = "{";
        String suffixChar = "}";
        return stringBuilder
                .append(escapeChar)
                .append(prefixChar)
                .append(key)
                .append(suffixChar)
                .toString();
    }

}
