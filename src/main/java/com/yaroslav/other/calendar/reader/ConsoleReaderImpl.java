package com.yaroslav.other.calendar.reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by employee on 5/29/15.
 */
public class ConsoleReaderImpl implements Reader {
    @Override
    public List<String> read() {
        List<String> listYearAndMonth = new ArrayList<>();
        String yearMonthDay = "";

        while (yearMonthDay.contains("stop")) {
            Scanner in = new Scanner(System.in);
            System.out.println("Please enter year month");
            yearMonthDay = in.nextLine();
            listYearAndMonth.add(yearMonthDay);
            System.out.println("Enter stop for exit");
        }

        return listYearAndMonth;
    }
}
