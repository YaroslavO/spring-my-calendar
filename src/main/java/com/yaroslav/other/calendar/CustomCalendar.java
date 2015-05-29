package com.yaroslav.other.calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by employee on 5/25/15.
 */
public class CustomCalendar {
    private List<YearCalendar> listYear;

    public CustomCalendar() {
        listYear = new ArrayList<YearCalendar>();
    }

    public void init(List<String> taskYear) {
        for (String targetYear: taskYear) {
            YearCalendar yearCalendar = new YearCalendar();
            yearCalendar.init(targetYear);
            listYear.add(yearCalendar);
        }
    }

    public List<YearCalendar> getListYear() {
        return listYear;
    }

}
