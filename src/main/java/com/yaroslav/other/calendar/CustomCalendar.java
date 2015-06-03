package com.yaroslav.other.calendar;

import com.yaroslav.other.calendar.reader.Reader;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by employee on 5/25/15.
 */
public class CustomCalendar {
    private List<YearCalendar> listYear = new ArrayList<YearCalendar>();
    private List<String> taskYear;

    public CustomCalendar(Reader reader) {
        taskYear = reader.read();
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
