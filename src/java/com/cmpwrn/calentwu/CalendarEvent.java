package com.cmpwrn.calentwu;

import java.time.LocalTime;
import java.util.List;

public class CalendarEvent {
    private final LocalTime startTime;
    private final Integer minutesDuration;
    private final String bodyText;
    private final List<CalendarEvent> dependsOn;

    public CalendarEvent(LocalTime startTime,
                         Integer minutesDuration,
                         String bodyText,
                         List<CalendarEvent> dependsOn) {

        this.startTime = startTime;
        this.minutesDuration = minutesDuration;
        this.bodyText = bodyText;
        this.dependsOn = dependsOn;
    }
}
