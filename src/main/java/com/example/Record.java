package com.example;

import java.time.LocalDate;

public record Record(String lastName, String firstName, LocalDate birthday, String email) {

    public String fullname() {
        return firstName + " " + lastName;
    }

}
