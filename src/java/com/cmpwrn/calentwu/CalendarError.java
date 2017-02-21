package com.cmpwrn.calentwu;

public class CalendarError {
    private String message;

    public CalendarError(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
