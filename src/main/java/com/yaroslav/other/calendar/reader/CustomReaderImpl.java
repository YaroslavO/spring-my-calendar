package com.yaroslav.other.calendar.reader;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by employee on 5/29/15.
 */
public class CustomReaderImpl implements Reader {

    @Override
    public List<String> read() {
        List<String> listYearAndMonth = new ArrayList<>();
        Calendar thisMonth = Calendar.getInstance();
        String yearAndMonth = thisMonth.get(Calendar.YEAR) + " " + (thisMonth.get(Calendar.MONTH) - 1)
                + " " + thisMonth.get(Calendar.MONTH) + " " + (thisMonth.get(Calendar.MONTH) + 1);
        listYearAndMonth.add(yearAndMonth);
        return listYearAndMonth;
    }
}
