package com.example;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

public class BirthdayTest {
    @Test
    public void shouldHaveGreetingSpecialBirthday() {
        // Person born on February, 29th should have their Birthday greeted on
        // February, 28th
        LocalDate today = LocalDate.of(2022, 02, 28);
        LocalDate birthday = LocalDate.of(2000, 02, 29);
        assertTrue("Should have greeting special birthday", Util.isBirthday(today, birthday));
    }

    @Test
    public void shouldHaveGreetingNormalFebruaryBirthday() {
        // Person born on February, 29th should have their Birthday greeted on
        // February, 28th
        LocalDate today = LocalDate.of(2022, 02, 1);
        LocalDate birthday = LocalDate.of(2000, 02, 1);
        assertTrue("Should have greeting february birthday", Util.isBirthday(today, birthday));
    }

    @Test
    public void shouldHaveGreetingNormalMarchBirthday() {
        // Person born on February, 29th should have their Birthday greeted on
        // February, 28th
        LocalDate today = LocalDate.of(2022, 03, 1);
        LocalDate birthday = LocalDate.of(2000, 03, 1);
        assertTrue("Should have greeting march birthday", Util.isBirthday(today, birthday));
    }
}
