package com.yaroslav.other.calendar;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by employee on 5/20/15.
 */
public class Week {
    private static final int COUNT_WEEK_DAYS = 7;
    private List<WeekDay> days;
    private Calendar dayOfWeek;
    private Calendar currentDate;

    public Week() {
    }

    public Week(Calendar date) {
        this.currentDate = new GregorianCalendar(date.get(Calendar.YEAR), date.get(Calendar.MONTH),
                date.get(Calendar.DAY_OF_MONTH));
        this.dayOfWeek = new GregorianCalendar(date.get(Calendar.YEAR), date.get(Calendar.MONTH),
                date.get(Calendar.DAY_OF_MONTH));
        this.dayOfWeek = setFirstDayInDateOfMonth(this.dayOfWeek);
    }

    public Week(Calendar currentDate, Calendar nextDate) {
        this.currentDate = currentDate;
        dayOfWeek = nextDate;
    }

    public List<WeekDay> getDays() {
        return days;
    }

    public Calendar getDate() {
        return currentDate;
    }

    private Calendar setFirstDayInDateOfMonth(Calendar date) {
        date.set(Calendar.DAY_OF_MONTH, 1);
        return date;
    }

    public void init() {
        days = new ArrayList<WeekDay>();
        if (checkFirstDayOfWeek()) {
            int numberDayOfWeek = dayOfWeek.get(Calendar.DAY_OF_WEEK) - 1;
            dayOfWeek.set(Calendar.MONTH, dayOfWeek.get(Calendar.MONTH) - 1);
            int countDayOFWeekMonthBefore = dayOfWeek.getActualMaximum(Calendar.DAY_OF_MONTH);
            dayOfWeek.set(Calendar.DAY_OF_MONTH, countDayOFWeekMonthBefore - numberDayOfWeek + 1);

            setWeekOfMonthBefore(numberDayOfWeek);

            dayOfWeek.set(Calendar.DAY_OF_MONTH, 1);
            dayOfWeek.set(Calendar.MONTH, dayOfWeek.get(Calendar.MONTH) + 1);
        }

        setWeekOfCurrentMonth();
    }

    private void setWeekOfCurrentMonth() {
        for (int numberDay = dayOfWeek.get(Calendar.DAY_OF_WEEK); numberDay <= COUNT_WEEK_DAYS; numberDay++) {
            days.add(new WeekDay(dayOfWeek, this));
            dayOfWeek = new GregorianCalendar(dayOfWeek.get(Calendar.YEAR), dayOfWeek.get(Calendar.MONTH),
                    dayOfWeek.get(Calendar.DAY_OF_MONTH) + 1);
        }
    }

    private void setWeekOfMonthBefore(int numberDayOfWeek) {
        for (int numberDay = 1; numberDay <= numberDayOfWeek;
             numberDay++) {
            days.add(new WeekDay(dayOfWeek, this));
            dayOfWeek = new GregorianCalendar(dayOfWeek.get(Calendar.YEAR), dayOfWeek.get(Calendar.MONTH),
                    dayOfWeek.get(Calendar.DAY_OF_MONTH) + 1);
        }
    }

    private boolean checkFirstDayOfWeek() {
        return dayOfWeek.get(Calendar.DAY_OF_WEEK) > 1;
    }

    public Week createNextWeek() {
        Week week = new Week(currentDate, dayOfWeek);
        week.init();
        return week;
    }

    public void setDays(List<WeekDay> days) {
        this.days = days;
    }

    @Override
    public boolean equals(Object obj) {
        List<WeekDay> weeksOfOtherWeek = ((Week) obj).getDays();

        if (weeksOfOtherWeek == null) {
            return false;
        }

        if (days == null) {
            return false;
        }
        
        if (weeksOfOtherWeek.size() != days.size()) {
            return false;
        }

        for (int i = 0; i < weeksOfOtherWeek.size(); i++) {
            if (!weeksOfOtherWeek.get(i).equals(days.get(i))) {
                return false;
            }
        }

        return true;
    }
}
