package com.yaroslav.other.calendar;

import java.util.Calendar;

/**
 * Created by employee on 5/20/15.
 */
public enum WeekDayType {
    SUNDAY(Calendar.SUNDAY, "SUN", true),
    MONDAY(Calendar.MONDAY, "MON", false),
    TUESDAY(Calendar.TUESDAY, "TUE", false),
    WEDNESDAY(Calendar.WEDNESDAY, "WED", false),
    THURSDAY(Calendar.THURSDAY, "THU", false),
    FRIDAY(Calendar.FRIDAY, "FRI", false),
    SATURDAY(Calendar.SATURDAY, "SAT", true);

    private String title;

    public boolean isWeekendDay() {
        return weekendDay;
    }

    private boolean weekendDay;

    WeekDayType(int id, String title, boolean weekendDay) {
        this.title = title;
        this.weekendDay = weekendDay;
    }

    @Override
    public String toString() {
        return title;
    }

    public static WeekDayType getByTitle(String title) {
        for (WeekDayType weekDayType : WeekDayType.values()) {
            if (weekDayType.toString().compareTo(title) != 0) continue;

            return weekDayType;
        }

        return null;
    }
}
