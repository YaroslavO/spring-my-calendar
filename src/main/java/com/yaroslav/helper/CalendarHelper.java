package com.yaroslav.helper;

import java.util.Calendar;
import java.util.Locale;

/**
 * Created by employee on 5/26/15.
 */
public class CalendarHelper {

    public static String getMonthNameByDate(Calendar date) {
        return date.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()).toLowerCase();
    }
}
