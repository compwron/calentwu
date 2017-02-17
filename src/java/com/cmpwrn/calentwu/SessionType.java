package com.cmpwrn.calentwu;

public enum SessionType {
    QA, BA, Dev, XD, UNKNOWN;

    public static SessionType from(String str) {
        for (SessionType sessionType : values()) {
            if (str.toUpperCase().equals(sessionType.name().toUpperCase())) {
                return sessionType;
            }
        }
        return UNKNOWN;
    }
}
