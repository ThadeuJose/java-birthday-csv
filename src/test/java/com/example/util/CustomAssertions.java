package com.example.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import com.example.Message;

public class CustomAssertions {

    public static void assertMessageWasCreated(List<Message> messages, Message message) {
        assertTrue("Should have " + message.toString() + " but only have " + messages.toString(),
                messages.contains(message));
    }

    public static void assertAllPeoplesReceiveMessage(List<Message> messages, int expectedQuantity) {
        assertEquals(expectedQuantity, messages.size());
    }

}
