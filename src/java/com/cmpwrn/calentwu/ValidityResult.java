package com.cmpwrn.calentwu;

import java.util.ArrayList;
import java.util.List;

public class ValidityResult {
    private boolean isValid;
    private List<CalendarError> errors = new ArrayList<>();

    public ValidityResult(boolean isValid, CalendarError calendarError) {
        this.isValid = isValid;
        this.errors.add(calendarError);
    }

    public ValidityResult(boolean isValid) {
        this.isValid = isValid;
    }

    public boolean isValid() {
        return isValid;
    }

    public List<CalendarError> getErrors() {
        return errors;
    }
}
