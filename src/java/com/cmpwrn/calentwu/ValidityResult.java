package com.cmpwrn.calentwu;

import java.util.ArrayList;
import java.util.List;

public class ValidityResult {
    private List<Error> errors = new ArrayList<>();

    public boolean isValid() {
        return true;
    }

    public List<Error> getErrors() {
        return errors;
    }
}
