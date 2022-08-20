package com.example.util;

import static com.example.util.CustomAssertions.assertMessageWasCreated;
import static com.example.util.CustomAssertions.assertAllPeoplesReceiveMessage;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.example.Message;

public class CustomAssertionsTest {

    @Test(expected = AssertionError.class)
    public void assertMessageWasCreatedShouldFail() {
        List<Message> messages = new ArrayList<>();
        messages.add(new Message("", "", ""));
        Message message = new Message("fail", "should fail", "really");
        assertMessageWasCreated(messages, message);
    }

    @Test
    public void assertMessageWasCreatedShouldPass() {
        List<Message> messages = new ArrayList<>();
        messages.add(new Message("pass", "should pass", "really should pass"));
        Message message = new Message("pass", "should pass", "really should pass");
        assertMessageWasCreated(messages, message);
    }

    @Test(expected = AssertionError.class)
    public void assertAllPeoplesReceiveMessageShouldFail() {
        List<Message> messages = new ArrayList<>();
        messages.add(new Message("", "", ""));
        assertAllPeoplesReceiveMessage(messages, 0);
    }

    @Test
    public void assertAllPeoplesReceiveMessageShouldPass() {
        List<Message> messages = new ArrayList<>();
        messages.add(new Message("pass", "should pass", "really should pass"));
        assertAllPeoplesReceiveMessage(messages, 1);
    }
}
