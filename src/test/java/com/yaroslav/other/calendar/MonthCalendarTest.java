package com.yaroslav.other.calendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Calendar;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

/**
 * Created by employee on 6/3/15.
 */
@RunWith(JUnit4.class)
public class MonthCalendarTest {

    private Calendar calendar;
    private MonthCalendar thisMonth;

    @Before
    public void setUp() throws Exception {
        calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JUNE, 2);
        thisMonth = new MonthCalendar(calendar);
    }

    @Test
    public void checkCountWeekOfMonth__returnsTrue__fromCurrentMonth() throws Exception {
        int countWeek = thisMonth.getCountWeeks(calendar);

        assertThat("count week of current month", countWeek, is(5));
    }

    @Test
    public void checkListWeek__returnsTrue__fromCurrentMonth() throws Exception {
        assertThat("list weeks of current month", thisMonth.getWeeks(), not(equalTo(null)));

    }
}