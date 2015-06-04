package com.yaroslav.other.calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by employee on 5/20/15.
 */
public class InputReader {
    private final int CUSTOM_YEAR = 2015;
    private final int CUSTOM_MONTH = 5;
    private final int CUSTOM_DAY = 9;

    public Calendar getFirstDayOfMonth() {
        Scanner in = new Scanner(System.in);
        String yearMonthDay;
        System.out.println("Please enter year month day");
        yearMonthDay = in.nextLine();
        return getDateWithString(yearMonthDay);
    }

    public Calendar getDateWithString(String stringDate) {
        int year = CUSTOM_YEAR;
        int month = CUSTOM_MONTH;
        int day = CUSTOM_DAY;
        int count = 1;

        if (stringDate.contains("/")) {
            stringDate = stringDate.replace("/", " ");
        }

        if (stringDate.contains(" ")) {
            for (String item : stringDate.split(" ")) {
                if (count == 1) {
                    year = Integer.valueOf(item);
                }

                if (count == 2) {
                    month = getMonth(item);
                }

                if (count == 3) {
                    day = Integer.valueOf(item);
                }

                count++;
            }
        }

        Calendar resultCalendar = Calendar.getInstance();
        resultCalendar.set(year, month, day);
        return resultCalendar;
    }

    public int getMonth(String value) {
        switch (value) {
            case "1" :
            case "01":
            case "jan":
            case "january": return 0;
        }
        if ((value.compareTo("1") == 0) || (value.compareTo("01") == 0) ||
                (value.compareTo("jan") == 0) || (value.compareTo("january") == 0)) {
            return 0;
        }

        if ((value.compareTo("2") == 0) || (value.compareTo("02") == 0) ||
                (value.compareTo("feb") == 0) || (value.compareTo("february") == 0)) {
            return 1;
        }

        if ((value.compareTo("3") == 0) || (value.compareTo("03") == 0) ||
                (value.compareTo("mar") == 0) || (value.compareTo("march") == 0)) {
            return 2;
        }

        if ((value.compareTo("4") == 0) || (value.compareTo("04") == 0) ||
                (value.compareTo("apr") == 0) || (value.compareTo("april") == 0)) {
            return 3;
        }

        if ((value.compareTo("5") == 0) || (value.compareTo("05") == 0) ||
                (value.compareTo("may") == 0)) {
            return 4;
        }

        if ((value.compareTo("6") == 0) || (value.compareTo("06") == 0) ||
                (value.compareTo("jun") == 0) || (value.compareTo("june") == 0)) {
            return 5;
        }

        if ((value.compareTo("7") == 0) || (value.compareTo("07") == 0) ||
                (value.compareTo("jul") == 0) || (value.compareTo("july") == 0)) {
            return 6;
        }

        if ((value.compareTo("8") == 0) || (value.compareTo("08") == 0) ||
                (value.compareTo("aug") == 0) || (value.compareTo("august") == 0)) {
            return 7;
        }

        if ((value.compareTo("9") == 0) || (value.compareTo("09") == 0) ||
                (value.compareTo("sep") == 0) || (value.compareTo("september") == 0)) {
            return 8;
        }

        if ((value.compareTo("10") == 0) || (value.compareTo("oct") == 0) ||
                (value.compareTo("october") == 0)) {
            return 9;
        }

        if ((value.compareTo("11") == 0) || (value.compareTo("nov") == 0) ||
                (value.compareTo("november") == 0)) {
            return 10;
        }

        if ((value.compareTo("12") == 0) || (value.compareTo("dec") == 0) ||
                (value.compareTo("december") == 0)) {
            return 11;
        }

        return 2;
    }
}
