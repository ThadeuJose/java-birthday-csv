package com.example;

import static com.example.Util.concat;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ConcatStringTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Test 1", Arrays.asList("Test 1") },
                { "Test 1 and Test 2", Arrays.asList("Test 1", "Test 2") },
                { "Test 1, Test 2 and Test 3", Arrays.asList("Test 1", "Test 2", "Test 3") },
                { "Test 1, Test 2, Test 3 and Test 4", Arrays.asList("Test 1", "Test 2", "Test 3", "Test 4") },

        });
    }

    private List<String> actual;
    private String expected;

    public ConcatStringTest(String expected, List<String> actual) {
        this.expected = expected;
        this.actual = actual;
    }

    @Test
    public void shouldConcatString() {
        assertEquals(expected, concat(actual));
    }

}
