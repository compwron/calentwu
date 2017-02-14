package com.cmpwrn.calentwu;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CalendarEventBuilder {
    private LocalTime startTime = LocalTime.now();
    private Integer minutesDuration = 90;
    private String bodyText = "https://example.com";
    private List<SessionType> sessionTypes = new ArrayList<>();
    private List<CalendarEvent> dependsOn = new ArrayList<>();
    private List<Presenter> presenters = new ArrayList<>();
    private LocalTime endTime = LocalTime.now();
    private String sessionName = "Caval";

    CalendarEvent build() {
        return new CalendarEvent(sessionName, startTime, endTime, minutesDuration, bodyText, sessionTypes, dependsOn, presenters);
    }

    public CalendarEventBuilder withStartTime(LocalTime startTime) {
        this.startTime = startTime;
        return this;
    }

    public CalendarEventBuilder withEndTime(LocalTime endTime) {
        this.endTime = endTime;
        return this;
    }

    public CalendarEventBuilder withBodyText(String bodyText) {
        this.bodyText = bodyText;
        return this;
    }

    public CalendarEventBuilder withSessionType(SessionType... sessionTypes) {
        for (SessionType sessionType : sessionTypes) {
            this.sessionTypes.add(sessionType);
        }
        return this;
    }

    public CalendarEventBuilder withPresenters(String... presenterNames) {
        for (String presenterName : presenterNames) {
            presenters.add(new Presenter(presenterName));
        }
        return this;
    }

    public CalendarEventBuilder withSessionName(String sessionName) {
        this.sessionName = sessionName;
        return this;
    }

    public CalendarEventBuilder withDependsOn(CalendarEvent calendarEvent) {
        this.dependsOn.add(calendarEvent);
        return this;
    }

    public CalendarEventBuilder withDuration(int duration) {
        this.minutesDuration = duration;
        return this;
    }
}
