package com.yaroslav.helper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Calendar;
import java.util.Locale;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by employee on 6/4/15.
 */
@RunWith(JUnit4.class)
public class CalendarHelperTest {
    private Calendar calendar;

    @Before
    public void setUp() throws Exception {
        calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JUNE, 2);
    }

    @Test
    public void checkNameMonth__returnsNameMonth__forCalendar() throws Exception {
        String nameMonth = CalendarHelper.getMonthNameByDate(calendar);
        String nameFieldCalendar = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()).toLowerCase();

        assertThat("check name month", nameMonth, is(nameFieldCalendar));
    }
}