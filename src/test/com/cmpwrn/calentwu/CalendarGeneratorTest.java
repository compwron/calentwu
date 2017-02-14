package com.cmpwrn.calentwu;

import org.junit.Test;

import java.time.LocalTime;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalendarGeneratorTest {
    private String config = "";

    @Test
    public void shouldAddOneCalendarEventToCalendarInFirstPosition() {
        CalendarEvent calendarEvent = new CalendarEventBuilder().withStartTime(LocalTime.of(9, 0)).build();

        String generate = new CalendarGenerator(config).generate(calendarEvent);
        assertThat(generate, is("???"));
    }
}
