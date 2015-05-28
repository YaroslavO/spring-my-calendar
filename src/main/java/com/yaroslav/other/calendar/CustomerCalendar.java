package com.yaroslav.other.calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by employee on 5/25/15.
 */
public class CustomerCalendar {
    private String task;
    private List<YearCalendar> listYear;

    public CustomerCalendar(String task) {
        this.task = task;
        listYear = new ArrayList<>();
    }

    public void init() {
        YearCalendar yearCalendar;
        List<MonthCalendar> months;
        MonthCalendar monthCalendar = new MonthCalendar();

        for (String year: task.split("\n")) {
            String [] parseYear = year.split(" ");
            yearCalendar = new YearCalendar(parseYear[0]);
            if (parseYear.length == 1) {
                months = new ArrayList<>();
                for (int month = 0; month < 12; month++) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.YEAR, Integer.valueOf(yearCalendar.getName()));
                    calendar.set(Calendar.MONTH, month);
                    calendar.set(Calendar.DAY_OF_MONTH, 1);
                    monthCalendar.init(calendar);
                    months.add(monthCalendar);
                    monthCalendar = new MonthCalendar();
                }
                yearCalendar.setMonths(months);
            } else {
                months = new ArrayList<>();
                for (int month = 1; month < parseYear.length; month++) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.YEAR, Integer.valueOf(yearCalendar.getName()));
                    calendar.set(Calendar.MONTH, getMonth(parseYear[month]));
                    calendar.set(Calendar.DAY_OF_MONTH, 1);
                    monthCalendar.init(calendar);
                    months.add(monthCalendar);
                    monthCalendar = new MonthCalendar();
                }
                yearCalendar.setMonths(months);
            }
            listYear.add(yearCalendar);
        }
    }

    public List<YearCalendar> getListYear() {
        return listYear;
    }

    public int getMonth(String value) {
        switch (value) {
            case "01":
            case "jan":
            case "january": return 0;
            case "02":
            case "feb":
            case "february": return 1;
            case "03":
            case "mar":
            case "march": return 2;
            case "04":
            case "apr":
            case "april": return 3;
            case "05":
            case "may": return 4;
            case "06":
            case "jun":
            case "june": return 5;
            case "07":
            case "jul":
            case "july": return 6;
            case "08":
            case "aug":
            case "august": return 7;
            case "09":
            case "sep":
            case "september": return 8;
            case "10":
            case "oct":
            case "october": return 9;
            case "11":
            case "now":
            case "november": return 10;
            case "12":
            case "dec":
            case "december": return 11;
        }

        return 2;
    }
}
