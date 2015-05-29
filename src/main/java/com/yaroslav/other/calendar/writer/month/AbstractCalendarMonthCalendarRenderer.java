package com.yaroslav.other.calendar.writer.month;

import com.yaroslav.other.calendar.MonthCalendar;
import com.yaroslav.other.calendar.Week;
import com.yaroslav.other.calendar.WeekDay;
import com.yaroslav.other.calendar.WeekDayType;

import java.util.Arrays;
import java.util.Calendar;

/**
 * Created by employee on 5/22/15.
 */
public abstract class AbstractCalendarMonthCalendarRenderer implements MonthCalendarRenderer {

    public String render(MonthCalendar mc){
        String result = "";
        result += getOpenMonthToken();
        result += getMonthHeader();
        result += getWeeks(mc);
        result += getCloseMonthToken();

        return result;
    }

    private String getWeeks(MonthCalendar mc) {
        String weeks = "";
        for (Week week: mc.getWeeks()){
            weeks += getOpenWeekToken();
            weeks += renderWeeks(week);
            weeks += getCloseWeekToken();
        }

        return weeks;
    }

    private String getMonthHeader() {
        String header = "";
        for (WeekDayType title: Arrays.asList(WeekDayType.values())) {
            header += getOpenTitleToken(title.toString());
            header += title.toString();
            header += getCloseTitleToken(title.toString());
        }

        return header;
    }

    private String renderWeeks (Week week) {
        String result = "";
        for (WeekDay day: week.getDays()) {
            result += renderDay(day);
        }

        return result;
    }

    private String renderDay(WeekDay day) {
        String result = "";
        result += getOpenDayToken(day);
        result += day.getDay().get(Calendar.DAY_OF_MONTH);
        result += getCloseDayToken();

        return result;
    }

    public String calculateDayColor(WeekDay day) {
        if (day.isTheCurrentDay()) return getCurrentDayColor();

        if (day.isOtherMonth()) return getOtherMonthColor();

        return day.getType().isWeekendDay()
                ? getWeekDayColor()
                : getDefaultDayColor();
    }


    public abstract String getOpenTitleToken(String title);
    public abstract String getCloseTitleToken(String title);
    public abstract String getOpenDayToken(WeekDay day);
    public abstract String getCloseDayToken();
    public abstract String getOpenWeekToken();
    public abstract String getCloseWeekToken();
    public abstract String getOpenMonthToken();
    public abstract String getCloseMonthToken();
    public abstract String getCurrentDayColor();
    public abstract String getOtherMonthColor();
    public abstract String getWeekDayColor();
    public abstract String getDefaultDayColor();
}
