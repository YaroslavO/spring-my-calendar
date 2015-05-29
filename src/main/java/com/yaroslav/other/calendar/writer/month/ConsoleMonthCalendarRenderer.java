package com.yaroslav.other.calendar.writer.month;

import com.yaroslav.other.calendar.WeekDay;
import com.yaroslav.other.calendar.WeekDayType;

/**
 * Created by employee on 5/22/15.
 */
public class ConsoleMonthCalendarRenderer extends AbstractCalendarMonthCalendarRenderer {

    public static final String COLOR_BLACK = "\u001B[30m";
    public static final String COLOR_GREEN = "\u001B[32m";
    public static final String COLOR_RED = "\u001B[31m";
    public static final String COLOR_YELLOW = "\u001B[33m";
    public static final String TABS = "\t";
    public static final String END_LINE = "\n";

    @Override
    public String getOpenTitleToken(String title) {
        String result = "";

        WeekDayType dayType = WeekDayType.getByTitle(title);

        result += TABS;
        result += dayType.isWeekendDay() ? COLOR_GREEN: COLOR_BLACK;

        return result;
    }

    @Override
    public String getCloseTitleToken(String title) {
        return COLOR_BLACK;
    }

    @Override
    public String getOpenDayToken(WeekDay day) {
        return calculateDayColor(day) + TABS;
    }

    @Override
    public String getCloseDayToken() {
        return COLOR_BLACK;
    }

    @Override
    public String getOpenWeekToken() {
        return END_LINE;
    }

    @Override
    public String getCloseWeekToken() {
        return END_LINE;
    }

    @Override
    public String getOpenMonthToken() {
        return "";
    }

    @Override
    public String getCloseMonthToken() {
        return "";
    }

    @Override
    public String getCurrentDayColor() {
        return COLOR_RED;
    }

    @Override
    public String getOtherMonthColor() {
        return COLOR_YELLOW;
    }

    @Override
    public String getWeekDayColor() {
        return COLOR_GREEN;
    }

    @Override
    public String getDefaultDayColor() {
        return COLOR_BLACK;
    }
}
