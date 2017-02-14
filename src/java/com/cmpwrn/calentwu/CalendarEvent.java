package com.cmpwrn.calentwu;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class CalendarEvent {
    private String sessionName;
    private LocalTime startTime;
    private Integer minutesDuration;
    private String csv;
    private String bodyText;
    private List<SessionType> sessionTypes;
    private List<CalendarEvent> dependsOn;
    private List<Presenter> presenters;
    private LocalTime endTime;

    public CalendarEvent(String sessionName, LocalTime startTime, LocalTime endTime, Integer minutesDuration, String bodyText, List<SessionType> sessionTypes, List<CalendarEvent> dependsOn, List<Presenter> presenters) {
        this.sessionName = sessionName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.minutesDuration = minutesDuration;
        this.bodyText = bodyText;
        this.sessionTypes = sessionTypes;
        this.dependsOn = dependsOn;
        this.presenters = presenters;
    }

    public CalendarEvent(String csv) {
        csv.split(",");
    }

    public String getSessionName() {
        return sessionName;
    }

    public Integer getMinutesDuration() {
        return minutesDuration;
    }

    public String getBodyText() {
        return bodyText;
    }

    public List<SessionType> getSessionTypes() {
        return sessionTypes;
    }

    public List<CalendarEvent> getDependsOn() {
        return dependsOn;
    }

    public List<Presenter> getPresenters() {
        return presenters;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CalendarEvent that = (CalendarEvent) o;

        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (minutesDuration != null ? !minutesDuration.equals(that.minutesDuration) : that.minutesDuration != null) return false;
        if (csv != null ? !csv.equals(that.csv) : that.csv != null) return false;
        if (bodyText != null ? !bodyText.equals(that.bodyText) : that.bodyText != null) return false;
        if (sessionTypes != null ? !sessionTypes.equals(that.sessionTypes) : that.sessionTypes != null) return false;
        if (dependsOn != null ? !dependsOn.equals(that.dependsOn) : that.dependsOn != null) return false;
        if (presenters != null ? !presenters.equals(that.presenters) : that.presenters != null) return false;
        return endTime != null ? endTime.equals(that.endTime) : that.endTime == null;
    }

    @Override
    public int hashCode() {
        int result = startTime != null ? startTime.hashCode() : 0;
        result = 31 * result + (minutesDuration != null ? minutesDuration.hashCode() : 0);
        result = 31 * result + (csv != null ? csv.hashCode() : 0);
        result = 31 * result + (bodyText != null ? bodyText.hashCode() : 0);
        result = 31 * result + (sessionTypes != null ? sessionTypes.hashCode() : 0);
        result = 31 * result + (dependsOn != null ? dependsOn.hashCode() : 0);
        result = 31 * result + (presenters != null ? presenters.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
//        "Feedback,9:00,90,https://example.com,dev/QA,Dev|Types of Testing,Linda|Anika";
        return sessionName + "," +
                startTime.toString() + "," +
                minutesDuration.toString() + "," +
                endTime.toString() + "," +
                sessionTypes() + "," +
                dependsOn() + "," +
                presenters() + "," +
                bodyText.toString();
    }

    private String presenters() {
        return presenters.stream().map(p -> p.getName()).collect(Collectors.joining("|"));
    }

    private String dependsOn() {
        return dependsOn.stream().map(st -> st.getSessionName()).collect(Collectors.joining("|"));
    }

    private String sessionTypes() {
        return sessionTypes.stream().map(st -> st.toString()).collect(Collectors.joining("|"));
    }

    public ValidityResult validityCheck() {
        return null;
    }
}
