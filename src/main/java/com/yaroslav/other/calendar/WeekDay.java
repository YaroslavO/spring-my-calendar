package com.yaroslav.other.calendar;

import java.util.Calendar;

/**
 * Created by employee on 5/20/15.
 */
public class WeekDay{
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

    public boolean isTheCurrentDayOfMonth() {
        return week.getDate().compareTo(day) == 0;
    }

    @Override
    public boolean equals(Object obj) {
        Calendar otherDay = ((WeekDay) obj).getDay();
        return day.get(Calendar.DATE) == otherDay.get(Calendar.DATE);
    }
}
