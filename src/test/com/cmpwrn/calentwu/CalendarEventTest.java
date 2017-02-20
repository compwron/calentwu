package com.cmpwrn.calentwu;

import org.junit.Test;

import java.time.LocalTime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalendarEventTest {

    @Test
    public void validityOfCalendarEventShouldHaveEqualStartEndDuration() {
        CalendarEvent calendarEvent = new CalendarEventBuilder()
                .withStartTime(LocalTime.of(9, 0))
                .withEndTime(LocalTime.of(10, 30))
                .withDuration(90)
                .build();
        assertThat(calendarEvent.validityCheck().isValid(), is(true));
        assertThat(calendarEvent.validityCheck().getErrors().size(), is(0));
    }

    @Test
    public void calendarEventWithMismatchedStartAndEndTimesShouldBeInvalid() {
        CalendarEvent calendarEvent = new CalendarEventBuilder()
                .withStartTime(LocalTime.of(9, 0))
                .withEndTime(LocalTime.of(10, 30))
                .withDuration(1)
                .build();
        assertThat(calendarEvent.validityCheck().isValid(), is(false));
        assertThat(calendarEvent.validityCheck().getErrors().size(), is(1));
        assertThat(calendarEvent.validityCheck().getErrors().get(0).toString(), is("Start time 09:00 and end time 10:30 are not 1 minutes apart"));
    }

    @Test
    public void shouldParseCalendarEventFromText() {
        String csv = "Feedback 101,09:00,90,10:30,Dev|QA,Mars Rover Dojo|Types of Testing,Linda|Anika,https://example.com";
        CalendarEvent calendarEvent = new CalendarEvent(csv);
        CalendarEvent expected = new CalendarEventBuilder()
                .withSessionName("Feedback 101")
                .withStartTime(LocalTime.of(9, 0))
                .withDuration(90)
                .withEndTime(LocalTime.of(10, 30))
                .withBodyText("https://example.com")
                .withSessionType(SessionType.QA, SessionType.Dev)
                .withDependsOn(new CalendarEventBuilder().withSessionName("Mars Rover Dojo").build())
                .withDependsOn(new CalendarEventBuilder().withSessionName("Types of Testing").build())
                .withPresenters("Linda", "Anika")
                .build();

        assertThat(calendarEvent.toString(), is(expected.toString()));
        assertThat(calendarEvent.toString(), is(csv));
    }

    @Test
    public void shouldGiveCsvReadyToString() {
        CalendarEvent calendarEvent = new CalendarEventBuilder()
                .withSessionName("Feedback 101")
                .withStartTime(LocalTime.of(9, 0))
                .withEndTime(LocalTime.of(10, 30))
                .withBodyText("calendar body text")
                .withSessionType(SessionType.QA, SessionType.Dev)
                .withDependsOn(new CalendarEventBuilder().withSessionName("Welcome to TWU").build())
                .withPresenters("Linda", "Anika")
                .build();

        assertThat(calendarEvent.toString(), is("Feedback 101,09:00,90,10:30,Dev|QA,Welcome to TWU,Linda|Anika,calendar body text"));
    }

    @Test
    public void shouldGoFullCircleParseToImport() {
        CalendarEvent calendarEvent1 = new CalendarEventBuilder()
                .withSessionName("Feedback 101")
                .withStartTime(LocalTime.of(9, 0))
                .withEndTime(LocalTime.of(10, 30))
                .withBodyText("calendar body text")
                .withSessionType(SessionType.QA, SessionType.Dev)
                .withDependsOn(new CalendarEventBuilder().withSessionName("Welcome to TWU").build())
                .withPresenters("Linda", "Anika")
                .build();

        String csv1 = calendarEvent1.toString();
        CalendarEvent calendarEvent2 = new CalendarEvent(csv1);
        assertThat(calendarEvent2.toString(), is(calendarEvent1.toString()));
    }

    public void shouldParseCalendarEventFromTextAndReturnErrorsIfAny() {

    }

}