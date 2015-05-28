package com.yaroslav.other.calendar;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by employee on 5/20/15.
 */
public class WeekDay {
    private WeekDayType type;
    private Calendar day;
    private Week week;

    public Calendar getDay() {
        return day;
    }

    public WeekDayType getType() {
        return type;
    }

    public WeekDay(Calendar date, Week week) {
        this.day = date;
        this.week = week;
        type = WeekDayType.values()[date.get(Calendar.DAY_OF_WEEK) - 1];
    }

    @Override
    public String toString() {
        return String.valueOf(day.get(Calendar.DAY_OF_MONTH));
    }

    public boolean isOtherMonth() {
        return week.getDate().get(Calendar.MONTH) != day.get(Calendar.MONTH);
    }

    public boolean isTheCurrentDay() {
        return week.getDate().compareTo(day) == 0;
    }
}
