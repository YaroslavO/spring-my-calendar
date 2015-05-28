package com.yaroslav.other.calendar.view.year;

/**
 * Created by Yaroslav on 25.05.2015.
 */
public class HTMLYearCalendarRendererToFile extends YearCalendarRendererToFile{
    public static final String START_BUTTON = "<a href=\"";
    public static final String END_NEXT_BUTTON = "\" class=\"btn btn-block btn-success\">Next month</a>";
    public static final String END_PREVIOUS_BUTTON = "\" class=\"btn btn-block btn-success\">Previous month</a>";
    public static final String END_LINE = "\n";
    public static final String BEGIN_DIV_HEADER = "<div class=\"row well\">";
    public static final String BEGIN_H = "<h3 style=\"color: green\" text-align: center>";
    public static final String END_H = "</h3>";
    public static final String END_DIV_HEADER = "</div>";


    @Override
    public String getHeaderMonthToken(String year, String month) {
        String result = "";
        result += BEGIN_DIV_HEADER;
        result += BEGIN_H;
        result += year;
        result += " ";
        result += month;
        result += END_H;
        result += END_DIV_HEADER;
        return result;
    }

    @Override
    public String getPreviousMonthToken(String link) {
        String result = "";
        result += START_BUTTON;
        result += link;
        result += END_PREVIOUS_BUTTON;
        result += END_LINE;
        return result;
    }

    @Override
    public String getNextMonthToken(String link) {
        String result = "";
        result += START_BUTTON;
        result += link;
        result += END_NEXT_BUTTON;
        result += END_LINE;
        return result;
    }
}
