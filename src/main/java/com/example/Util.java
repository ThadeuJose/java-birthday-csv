package com.example;

import static java.util.stream.Collectors.joining;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.util.List;

public class Util {
    public static String concat(List<String> str) {
        if (hasOnlyOneElement(str)) {
            return firstElement(str);
        }

        String DELIMITER = ", ";
        String SEPARATOR = " and ";
        return String.join(SEPARATOR, concatFirstElementsOfList(str, DELIMITER), lastElement(str));
    }

    private static boolean hasOnlyOneElement(List<String> str) {
        return str.size() == 1;
    }

    private static String firstElement(List<String> str) {
        return str.get(0);
    }

    private static String concatFirstElementsOfList(List<String> str, String delimiter) {
        int lastIndex = str.size() - 1;
        return str.stream().limit(lastIndex).collect(joining(delimiter));
    }

    private static String lastElement(List<String> str) {
        int lastIndex = str.size() - 1;
        return str.get(lastIndex);
    }

    public static boolean isBirthday(LocalDate today, LocalDate birthday) {
        final MonthDay FEBRUARY_29 = MonthDay.of(Month.FEBRUARY.getValue(), 29);
        final MonthDay FEBRUARY_28 = MonthDay.of(Month.FEBRUARY.getValue(), 28);

        if (FEBRUARY_29.equals(MonthDay.from(birthday))) {
            return FEBRUARY_28.equals(MonthDay.from(today));
        }
        return MonthDay.from(today).equals(MonthDay.from(birthday));
    }
}
