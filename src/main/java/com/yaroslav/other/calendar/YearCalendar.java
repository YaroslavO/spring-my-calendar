package com.yaroslav.other.calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by employee on 5/25/15.
 */
public class YearCalendar {
    private Integer name;
    private List<MonthCalendar> months;

    public YearCalendar () {
        months = new ArrayList<>();
    }

    public void init(String targetYear) {

        String [] parseYear = targetYear.trim().split(" ");

        this.name = Integer.valueOf(parseYear[0]);

        if (isOnlyYear(parseYear)) {
            createAllYear();
        } else {
            createSomeMonth(parseYear);
        }
    }

    private void createSomeMonth(String[] parseYear) {
        for (int month = 1; month < parseYear.length; month++) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, this.name);
            calendar.set(Calendar.MONTH, getMonth(parseYear[month]));
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            MonthCalendar monthCalendar = new MonthCalendar(calendar);

            months.add(monthCalendar);
        }
    }

    private void createAllYear() {
        for (int month = 0; month < 12; month++) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, this.name);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            MonthCalendar monthCalendar = new MonthCalendar(calendar);

            months.add(monthCalendar);
        }
    }

    private boolean isOnlyYear(String[] parseYear) {
        return parseYear.length == 1;
    }

    public int getMonth(String value) {
        switch (value) {
            case "0":
            case "01":
            case "jan":
            case "january": return 0;
            case "2":
            case "02":
            case "feb":
            case "february": return 1;
            case "3":
            case "03":
            case "mar":
            case "march": return 2;
            case "4":
            case "04":
            case "apr":
            case "april": return 3;
            case "5":
            case "05":
            case "may": return 4;
            case "6":
            case "06":
            case "jun":
            case "june": return 5;
            case "7":
            case "07":
            case "jul":
            case "july": return 6;
            case "8":
            case "08":
            case "aug":
            case "august": return 7;
            case "9":
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

    public List<MonthCalendar> getMonths() {
        return months;
    }

    public Integer getName() {
        return name;
    }
}
