package com.cmpwrn.calentwu;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ValidityResultTest {
    @Test
    public void shouldAcceptValidityTokenAndPopulateErrors(){
        ValidityResult validityResult = new ValidityResult(true);
        assertThat(validityResult.isValid(), is(true));
    }

}