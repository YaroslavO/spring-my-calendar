package com.yaroslav.other.calendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Calendar;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by employee on 6/3/15.
 */

@RunWith(JUnit4.class)
public class WeekDayTest {

    private Calendar calendar;

    @Before
    public void setUp() throws Exception {
        calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JUNE, 2);
    }

    @Test
    public void toString__returnsDayOfMonth() throws Exception {
        WeekDay weekDay = new WeekDay(calendar, null);

        String dayOfMonth = weekDay.toString();

        assertThat(dayOfMonth, is("2"));
    }

    @Test
    public void isOtherMonth__returnsFalse__forCurrentMonth() throws Exception {
        WeekDay weekDay = new WeekDay(calendar, new Week(calendar));

        boolean otherMonth = weekDay.isOtherMonth();

        assertThat("is current month", otherMonth, is(false));
    }

    @Test
    public void isOtherMonth__returnsTrue__forOtherMonth() throws Exception {
        WeekDay weekDay = new WeekDay(calendar, new Week(calendar));

        boolean otherMonth = !weekDay.isOtherMonth();

        assertThat("is other month", otherMonth, is(true));
    }

    @Test
    public void isCurrentDate__returnsTrue__forCurrentMonth() throws Exception {
        WeekDay weekDay = new WeekDay(calendar, new Week(calendar));

        boolean currentDate = weekDay.isTheCurrentDayOfMonth();

        assertThat("is current date of this month", currentDate, is(false));
    }
}