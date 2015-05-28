package com.yaroslav.other.calendar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 5/25/15.
 */
public class YearCalendar {
    private String name;
    private List<MonthCalendar> months;

    public YearCalendar (String name) {
        this.name = name;
        months = new ArrayList<>();
    }

    public List<MonthCalendar> getMonths() {
        return months;
    }

    public void setMonths(List<MonthCalendar> months) {
        this.months = months;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
