package com.yaroslav.other.calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by employee on 5/20/15.
 */
public class MonthCalendar {
    private List<Week> weeks = new ArrayList<Week>();;
    private Calendar date = Calendar.getInstance();

    public MonthCalendar(Calendar date) {
        this.date.setTime(date.getTime());
        init();
    }

    public List<Week> getWeeks() {
        return weeks;
    }

    private void init() {
        Week currentWeek;
        currentWeek = new Week(date);
        date.set(Calendar.DAY_OF_MONTH, 1);
        int countWeeks = getCountWeeks(date) - 1;
        currentWeek.init();
        weeks.add(currentWeek);
        for (int count = 0; count < countWeeks; count++) {
            currentWeek = weeks.get(count).createNextWeek();
            weeks.add(currentWeek);
        }
    }

    @Override
    public String toString() {
        return weeks
                .stream()
                .map(p -> p.toString())
                .collect(Collectors.joining("\n\n"));
    }

    public int getCountWeeks(Calendar calendar) {
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int cntDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int countWeek = (dayOfWeek + cntDayOfMonth) / Calendar.SATURDAY;

        if (((dayOfWeek + cntDayOfMonth) % Calendar.SATURDAY) != 0) {
            countWeek += 1;
        }

        return countWeek;
    }

    public Calendar getDate() {
        return date;
    }
}
